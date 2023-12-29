package com.ua.hlibkorbov.javajuniorleveltechnicaltask.repository;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.ShowingJobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingJobsRepository extends JpaRepository<ShowingJobsEntity, Long> {
}
