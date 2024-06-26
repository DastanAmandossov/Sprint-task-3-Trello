package org.example.techordatrello.repository;

import org.example.techordatrello.model.Folders;
import org.example.techordatrello.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {

    List <Tasks> findAllByFolderId(Long folderId);
}
