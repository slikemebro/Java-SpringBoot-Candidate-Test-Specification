package com.ua.hlibkorbov.javajuniorleveltechnicaltask.repository;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.JobItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobItemRepository extends JpaRepository<JobItemEntity, Long> {
}
