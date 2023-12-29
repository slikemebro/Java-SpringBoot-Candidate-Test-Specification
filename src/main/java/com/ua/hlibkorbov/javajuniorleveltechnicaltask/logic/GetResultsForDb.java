package com.ua.hlibkorbov.javajuniorleveltechnicaltask.logic;

import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.JobFunctionTypesEntity;
import com.ua.hlibkorbov.javajuniorleveltechnicaltask.entity.ShowingJobsEntity;
import com.ua.hlibkorbov.javajuniorleveltechnicaltask.service.TagsService;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Log4j2
public class GetResultsForDb {

    private static TagsService tagsService;

    @Value("${url}")
    private static String url;

    @Autowired
    public GetResultsForDb(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    public static void getResults(String accountingAndFinance, int jobFunction) {
        Document document;
        ShowingJobsEntity showingJobsEntity = new ShowingJobsEntity();
        JobFunctionTypesEntity jobFunctionTypesEntity = new JobFunctionTypesEntity();
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Element countOfJobs = document.selectFirst(".sc-beqWaB.eJrfpP");
        List<Element> tagsElementsList = document.select(".sc-dmqHEX.dncTlc");
        String countOfJobsText;
        try {
            countOfJobsText = countOfJobs.text().replaceAll("[^0-9]", "");
            log.info("Count of jobs: " + countOfJobsText);
        } catch (NullPointerException e) {
            log.error("Element count of jobs not found");
            throw new RuntimeException(e);
        }
        for (Element element : tagsElementsList) {
            tagsService.add(element.text());
        }

        showingJobsEntity.setCount(Long.parseLong(countOfJobsText));
        showingJobsEntity.setNameOfJobFunction(accountingAndFinance);
        jobFunctionTypesEntity.setName(accountingAndFinance);
    }
}
