package com.ua.hlibkorbov.javajuniorleveltechnicaltask.repository;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.JobFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobFunctionRepository extends JpaRepository<JobFunctionEntity, Long> {

}
