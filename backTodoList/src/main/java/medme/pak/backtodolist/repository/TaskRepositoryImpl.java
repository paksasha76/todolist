package medme.pak.backtodolist.repository;

import medme.pak.backtodolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryImpl extends JpaRepository<Task, Long>{
}
