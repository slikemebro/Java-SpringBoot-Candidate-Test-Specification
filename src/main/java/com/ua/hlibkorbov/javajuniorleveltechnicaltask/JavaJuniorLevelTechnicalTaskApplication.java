package com.ua.hlibkorbov.javajuniorleveltechnicaltask;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.logic.JobScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaJuniorLevelTechnicalTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaJuniorLevelTechnicalTaskApplication.class, args);

        JobScraper.scrape();
    }

}
