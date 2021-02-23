package com.sample.test.demo.service;

import com.sample.test.demo.exception.ResourceNotFoundException;
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

    public TaskDetails getTaskById(long id){
        Optional<TaskDetails> taskDetails= taskRepository.findById(id);
        if(taskDetails.isPresent()){
            return taskDetails.get();
        }else {
            throw new ResourceNotFoundException("Id does not exist"+id);
        }

    }
    public TaskDetails updateTask(TaskDetails taskDetails){
        Optional<TaskDetails> updateTask= taskRepository.findById(taskDetails.getId());
        if(updateTask.isPresent()){
            TaskDetails updateTaskDetails=updateTask.get();
            updateTaskDetails.setId(taskDetails.getId());
            updateTaskDetails.setName(taskDetails.getName());
            updateTaskDetails.setAssignee(taskDetails.getAssignee());
            updateTaskDetails.setStatus(taskDetails.getStatus());
            updateTaskDetails.setCreatedDate(taskDetails.getCreatedDate());
            return updateTaskDetails;
        }
        else {
            throw new ResourceNotFoundException("Record not found with id"+ taskDetails.getId());
        }
    }
    public void deleteTask(long id){
        Optional<TaskDetails> taskDetails= taskRepository.findById(id);
        if(taskDetails.isPresent()){
            taskRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException();
        }
    }

}
