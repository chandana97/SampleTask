package com.sample.test.demo.service;

import com.sample.test.demo.model.Status;
import com.sample.test.demo.model.TaskDetails;
import com.sample.test.demo.repo.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskServiceTest {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;
    TaskDetails taskDetails;
    List<TaskDetails> taskDetailsList;
    Status status;
    @BeforeAll
    public void before(){
        taskDetails=new TaskDetails();
        taskDetails.setId(123);
        taskDetails.setAssignee("setasssign");
        taskDetails.setName("laskhmipriya");
        taskDetails.setCreatedDate(1);
        taskDetails.setStatus(Status.valueOf("defined"));
        taskDetailsList=new ArrayList<>();
        taskDetailsList.add(taskDetails);
    }

    @org.junit.jupiter.api.Test
    void getTaskDetails() {
        when(taskRepository.findAll()).thenReturn(taskDetailsList);
        taskService.getTaskDetails();
        Assertions.assertNotNull(taskService.getTaskDetails());
    }
}