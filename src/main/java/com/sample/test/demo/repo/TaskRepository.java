package com.sample.test.demo.repo;

import com.sample.test.demo.model.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskDetails,Long> {
}
