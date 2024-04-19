package org.example.techordatrello.repository;

import org.example.techordatrello.model.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories,Long> {
}
