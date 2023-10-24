package medme.pak.backtodolist.controller;

import medme.pak.backtodolist.model.Task;
import medme.pak.backtodolist.serveces.TaskServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class MainPageTaskController {

    @Autowired
    private TaskServce service;

    @GetMapping("")
    public ResponseEntity<ArrayList<Task>> showTasks() {
        return new ResponseEntity<>((ArrayList<Task>) service.showAllTasksFromDataBase(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<HttpStatus> createTask(@RequestBody Task task) {
        service.saveTask(task) ;

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("create")
    public ResponseEntity<Task> test() {
        Task task;

        ArrayList<Task> arrayList =(ArrayList<Task>) service.showAllTasksFromDataBase();
        task = arrayList.get(arrayList.size() -1);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
