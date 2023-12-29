package com.ua.hlibkorbov.javajuniorleveltechnicaltask.repository;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.JobFunctionTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobFunctionTypesRepository extends JpaRepository<JobFunctionTypesEntity, Long> {
}
