package org.example.techordatrello.service;

import org.example.techordatrello.model.Tasks;
import org.example.techordatrello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Tasks> getAllTasks(){

        return taskRepository.findAll();
    }

    public Tasks getTasksById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void addTask(Tasks task){
        taskRepository.save(task);
    }

    public List<Tasks> getAllTasksByFoldersId(Long folderId){

        return taskRepository.findAllByFolderId(folderId);
    }

}
