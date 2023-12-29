package com.ua.hlibkorbov.javajuniorleveltechnicaltask.service;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.TagsEntity;
import com.ua.hlibkorbov.javajuniorleveltechnicaltask.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TagsService {
    @Autowired
    private final TagsRepository tagsRepository;

    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }


    public void add(String text) {
        Optional<TagsEntity> tagsEntityOptional = tagsRepository.findByName(text);
        if (tagsEntityOptional.isEmpty()){
            TagsEntity tagsEntity = new TagsEntity();
            tagsEntity.setName(text);
            tagsRepository.save(tagsEntity);
        }
    }
}
