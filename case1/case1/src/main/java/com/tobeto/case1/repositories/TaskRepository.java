package com.tobeto.case1.repositories;

import com.tobeto.case1.entities.concretes.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
