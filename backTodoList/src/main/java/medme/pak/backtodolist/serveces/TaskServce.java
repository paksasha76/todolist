package medme.pak.backtodolist.serveces;

import medme.pak.backtodolist.model.Task;
import medme.pak.backtodolist.repository.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskServce {

    @Autowired
    private TaskRepositoryImpl taskRepository;

    public TaskServce() {
    }

    public void saveTask(Task task) {
        SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date currentDate = new Date();
        String dateString = stringDateFormat.format(currentDate);
        task.setLastUpdatedTask(dateString);
        task.setCreatedTask(dateString);
        taskRepository.save(task);
    }

    public List<Task> showAllTasksFromDataBase() {
        return taskRepository.findAll();
    }
}
