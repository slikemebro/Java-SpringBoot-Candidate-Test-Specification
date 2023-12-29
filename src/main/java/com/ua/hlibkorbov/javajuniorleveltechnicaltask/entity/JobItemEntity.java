package com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "job_items")
public class JobItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String positionName;
    @NonNull
    private String urlToOrganization;
    @NonNull
    private String logoUrl;
    @NonNull
    private String organizationTitle;
    @NonNull
    private String laborFunction;
    @NonNull
    private String address;
    @NonNull
    private LocalDate postedDate;
    @NonNull
    private String description;

}
