package com.ua.hlibkorbov.javajuniorleveltechnicaltask.repository;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagsRepository extends JpaRepository<TagsEntity, Long> {

    Optional<TagsEntity> findByName(String name);
}
