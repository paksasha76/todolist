package medme.pak.backtodolist.serveces;

import jakarta.persistence.Entity;
import medme.pak.backtodolist.dto.TaskDTO;
import medme.pak.backtodolist.model.Task;
import medme.pak.backtodolist.repository.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServce {
    @Autowired
    private TaskDTO taskDTO;

    public TaskServce() {
    }

    public HttpStatus saveTask(Task task) {
        String currentDateAndTime = getCurrentDateAndTime();
        task.setLastUpdatedTask(currentDateAndTime);
        task.setCreatedTask(currentDateAndTime);
        HttpStatus status = taskDTO.save(task);

        return HttpStatus.OK;
    }

    public HttpStatus updateTask(Task task) {
        String currentDateAndTime = getCurrentDateAndTime();

        task.setLastUpdatedTask(currentDateAndTime);

        HttpStatus status = taskDTO.updateTask(task);

        return status;
    }

    public HttpStatus deleteTask(Long id) {
        taskDTO.deleteTask(id);

        return HttpStatus.NOT_FOUND;
    }

    public List<Task> showAllTasksFromDataBase() {
        return taskDTO.getAllTask();
    }

    public String getCurrentDateAndTime() {
        SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date currentDate = new Date();
        String currentDateAndTime = stringDateFormat.format(currentDate);
        return currentDateAndTime;
    }
}
