package io.github.konstantinbushuev.tasktracker05deployment.repository;

import io.github.konstantinbushuev.tasktracker05deployment.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
