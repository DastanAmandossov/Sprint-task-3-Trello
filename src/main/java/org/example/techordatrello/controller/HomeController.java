package org.example.techordatrello.controller;

import org.example.techordatrello.model.TaskCategories;
import org.example.techordatrello.model.Tasks;
import org.example.techordatrello.model.Folders;
import org.example.techordatrello.service.FolderService;
import org.example.techordatrello.service.TaskCategoriesService;
import org.example.techordatrello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FolderService folderService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskCategoriesService taskCategoriesService;

    @GetMapping(value = "/folders")
    public String foldersPage(Model model){
        model.addAttribute("allFolders", folderService.getAllFolders());
        return "index";
    }

    @PostMapping(value="/addFolder")
    public String addFolder(@RequestParam(value = "folderName") String folderName){
        Folders folder = new Folders();
        folder.setName(folderName);
        folderService.addFolder(folder);
        return "redirect:/";
    }

    @GetMapping(value = "/folders/details/{id}")
    public String detailsFolder(@PathVariable(value="id") Long id,
                                Model model){
        Folders folder = folderService.getFolderById(id);
        model.addAttribute("detailsFolder", folder);
        List<Tasks> tasksByFolder = taskService.getAllTasksByFoldersId(id);
        model.addAttribute("allTaskByFolderId", tasksByFolder);
        List<TaskCategories>taskCategories=taskCategoriesService.getAllTaskCategories();
        model.addAttribute("allTaskCat", taskCategories);
        return "detailsFolder";
    }

    @PostMapping(value = "/addTask/{folderId}")
    public String addTask(@RequestParam(value="taskName") String taskName,
                          @RequestParam(value="taskDesc") String taskDesc,
                          @PathVariable(value="folderId") Long folderId){
        Folders folder = folderService.getFolderById(folderId);
        Tasks task = new Tasks();
        task.setFolder(folder);
        task.setTitle(taskName);
        task.setDescription(taskDesc);
        task.setStatus(0);
        taskService.addTask(task);
        return "redirect:/folders/details/"+folderId;
    }

    @GetMapping(value ="/folders/detailsFolder/detailsTask/{taskId}")
    public String detailsTask(@PathVariable(value = "taskId") Long taskId,
                              Model model){
        Tasks task = taskService.getTasksById(taskId);
        model.addAttribute("taskByFolder", task);
        return "detailsTask";
    }
}
