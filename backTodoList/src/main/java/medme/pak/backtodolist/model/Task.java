package medme.pak.backtodolist.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_task")
    private String nameTask;

    @Column(name = "description_task")
    private String descriptionTask;

    @Enumerated(EnumType.STRING)
    private Status statusTask;

    @Column(name = "date_created_task")
    private String createdTask;

    @Column(name = "date_lasta_update_task")
    private String lastUpdatedTask;

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
