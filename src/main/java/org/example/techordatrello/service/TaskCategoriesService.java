package org.example.techordatrello.service;

import org.example.techordatrello.model.TaskCategories;
import org.example.techordatrello.repository.TaskCategoriesRepository;
import org.example.techordatrello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoriesService {

    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;

    public List<TaskCategories> getAllTaskCategories(){
        return taskCategoriesRepository.findAll();
    }
}
