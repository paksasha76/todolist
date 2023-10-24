package medme.pak.backtodolist.controller;

import medme.pak.backtodolist.model.Status;
import medme.pak.backtodolist.model.Task;
import medme.pak.backtodolist.serveces.TaskServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class MainPageTaskController {

    @Autowired
    private TaskServce servce;
    Task task;
    @GetMapping("/")
    public ResponseEntity<ArrayList<Task>> showTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

//        tasks.add(new Task("1", "2", Status.NOTDONE));
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<HttpStatus> createTask(@RequestBody Task task) {

        System.out.println("task = " + task);

        this.task = servce.saveTask(task) ;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("create")
    public ResponseEntity<Task> test() {

        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
