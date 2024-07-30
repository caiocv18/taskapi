package com.caiocv18.taskapi.view;

import com.caiocv18.taskapi.model.Task;
import com.caiocv18.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskView {

    private final TaskService taskService;

    @Autowired
    public TaskView(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public String createTask(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        taskService.saveTask(task);
        redirectAttributes.addFlashAttribute("message", "Tarefa adicionada com sucesso!");
        return "redirect:/tasks";
    }

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.findAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa inválida:" + id));
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        task.setId(id);
        taskService.updateTask(task);
        redirectAttributes.addFlashAttribute("message", "Tarefa atualizada com sucesso!");
        return "redirect:/tasks";
    }

    @GetMapping("/add")
    public String addTaskForm(Task task) {
        return "add";
    }

    @GetMapping("/delete/{id}")
    public String deleteTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa inválida:" + id));
        model.addAttribute("task", task);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taskService.deleteTask(id);
        redirectAttributes.addFlashAttribute("message", "Tarefa deletada com sucesso!");
        return "redirect:/tasks";
    }
}