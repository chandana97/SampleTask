package com.sample.test.demo.web;

import com.sample.test.demo.model.TaskDetails;
import com.sample.test.demo.service.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @ApiOperation(value = "add a task")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "task created successfully"),
            @ApiResponse(code =401,message = "you are not authorized to view the resource"),
            @ApiResponse(code=403,message = "Acessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code=404,message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/addTask",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<TaskDetails> createTask(@RequestBody TaskDetails taskDetails){
        return ResponseEntity.ok().body(this.taskService.createTask(taskDetails));
    }
    @ApiOperation(value = "Get Taskdetails")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "task created successfully"),
            @ApiResponse(code =401,message = "you are not authorized to view the resource"),
            @ApiResponse(code=403,message = "Acessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code=404,message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/getTaskDetails",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<TaskDetails>> getTaskDetails(){
        return ResponseEntity.ok().body(taskService.getTaskDetails());
    }

}
