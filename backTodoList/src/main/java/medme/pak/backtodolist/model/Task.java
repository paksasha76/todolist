package medme.pak.backtodolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "tasks")
public class Task {
    @Id
    private Long id;

    private String nameTask;

    private String descriptionTask;

    private Status statusTask;

    private String createdTask;

    private String lastUpdatedTask;

//    public Task(String nameTask, String descriptionTask, Status statusTask) {
//        this.nameTask = nameTask;
//        this.descriptionTask = descriptionTask;
//        this.statusTask = statusTask;
//
//        SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
//        Date currentDate = new Date();
//        String dateString = stringDateFormat.format(currentDate);
//        this.createdTask = dateString;
//        this.lastUpdatedTask = dateString;
//    }


    public void setLastUpdatedTask() {
        SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date currentDate = new Date();
        String dateString = stringDateFormat.format(currentDate);
        lastUpdatedTask = dateString;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nameTask='" + nameTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", statusTask=" + statusTask +
                ", createdTask='" + createdTask + '\'' +
                ", lastUpdatedTask='" + lastUpdatedTask + '\'' +
                '}';
    }
}
