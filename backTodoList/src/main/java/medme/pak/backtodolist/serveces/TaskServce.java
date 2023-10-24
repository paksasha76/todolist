package medme.pak.backtodolist.serveces;

import medme.pak.backtodolist.model.Task;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaskServce {

    public TaskServce() {
    }

    public Task saveTask(Task task) {
        SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date currentDate = new Date();
        String dateString = stringDateFormat.format(currentDate);
        task.setLastUpdatedTask(dateString);
        task.setCreatedTask(dateString);
        return task;
    }
}
