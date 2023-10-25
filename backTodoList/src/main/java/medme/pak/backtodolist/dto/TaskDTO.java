package medme.pak.backtodolist.dto;

import medme.pak.backtodolist.model.Task;
import medme.pak.backtodolist.repository.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TaskDTO {

    @Autowired
    private TaskRepositoryImpl repositoryTask;

    public HttpStatus save(Task task) {
        if (task.getNameTask() != null) {
            repositoryTask.save(task);
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

    public HttpStatus updateTask(Task task) {
        Optional<Task> optionalTask = repositoryTask.findById(task.getId());

        if (optionalTask.isPresent()) {
            Task entity = optionalTask.get();
            entity.setNameTask(task.getNameTask());
            entity.setDescriptionTask(task.getDescriptionTask());
            entity.setLastUpdatedTask(task.getLastUpdatedTask());
            entity.setStatusTask(task.getStatusTask());
            repositoryTask.save(entity);
            return HttpStatus.OK;
        }
        
        return HttpStatus.NOT_FOUND;
    }

    public List<Task> getAllTask() {
        return repositoryTask.findAll();
    }

    public HttpStatus deleteTask(Long id) {
        Optional<Task> optionalTask = repositoryTask.findById(id);

        if (optionalTask.isPresent()) {
            Task entity = optionalTask.get();
            repositoryTask.delete(entity);
            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }
}
