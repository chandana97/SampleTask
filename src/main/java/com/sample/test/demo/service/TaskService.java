package com.sample.test.demo.service;

import com.sample.test.demo.model.TaskDetails;
import com.sample.test.demo.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskDetails createTask(TaskDetails taskDetails){
        return taskRepository.save(taskDetails);
    }
    public List<TaskDetails> getTaskDetails(){
        List<TaskDetails> taskDetailsList = taskRepository.findAll();
        return taskDetailsList;
    }

}
