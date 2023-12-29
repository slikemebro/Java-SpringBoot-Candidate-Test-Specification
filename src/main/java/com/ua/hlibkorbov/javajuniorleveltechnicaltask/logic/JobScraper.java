package com.ua.hlibkorbov.javajuniorleveltechnicaltask.logic;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Log4j2
public class JobScraper {

    private static final String ALL = "All";
    private static final String ACCOUNTING_AND_FINANCE = "Accounting & Finance";
    private static final String ADMINISTRATIVE = "Administrative";
    private static final String CUSTOMER_SERVICE = "Customer Service";
    private static final String DATA_SCIENCE = "Data Science";
    private static final String DESIGN = "Design";
    private static final String IT = "IT";
    private static final String LEGAL = "Legal";
    private static final String MARKETING_AND_COMMUNICATIONS = "Marketing & Communications";
    private static final String OPERATIONS = "Operations";
    private static final String OTHER_ENGINEERING = "Other Engineering";
    private static final String PEOPLE_AND_HR = "People & HR";
    private static final String PRODUCT = "Product";
    private static final String QUALITY_ASSURANCE = "Quality Assurance";
    private static final String SALES_AND_BUSINESS_DEVELOPMENT = "Sales & Business Development";
    private static final String SOFTWARE_ENGINEERING = "Software Engineering";
    private static final Scanner SC = new Scanner(System.in);


    public static void scrape() {
        boolean flag = true;
        while (flag) {
            log.info("""
                                           
                            1. {}
                            2. {}
                            3. {}
                            4. {}
                            5. {}
                            6. {}
                            7. {}
                            8. {}
                            9. {}
                            10. {}
                            11. {}
                            12. {}
                            13. {}
                            14. {}
                            15. {}
                            16. {}
                            17. Clear all filters
                            18. Exit
                            """, ALL, ACCOUNTING_AND_FINANCE, ADMINISTRATIVE, CUSTOMER_SERVICE, DATA_SCIENCE, DESIGN, IT, LEGAL,
                    MARKETING_AND_COMMUNICATIONS, OPERATIONS, OTHER_ENGINEERING, PEOPLE_AND_HR, PRODUCT, QUALITY_ASSURANCE,
                    SALES_AND_BUSINESS_DEVELOPMENT, SOFTWARE_ENGINEERING);
            log.info("Enter job function: ");
            int jobFunction = SC.nextInt();
            switch (jobFunction) {
                case 2 -> ShowResultsInBrowser.showResult(ACCOUNTING_AND_FINANCE);
                case 3 -> ShowResultsInBrowser.showResult(ADMINISTRATIVE);
                case 4 -> ShowResultsInBrowser.showResult(CUSTOMER_SERVICE);
                case 5 -> ShowResultsInBrowser.showResult(DATA_SCIENCE);
                case 6 -> ShowResultsInBrowser.showResult(DESIGN);
                case 7 -> ShowResultsInBrowser.showResult(IT);
                case 8 -> ShowResultsInBrowser.showResult(LEGAL);
                case 9 -> ShowResultsInBrowser.showResult(MARKETING_AND_COMMUNICATIONS);
                case 10 -> ShowResultsInBrowser.showResult(OPERATIONS);
                case 11 -> ShowResultsInBrowser.showResult(OTHER_ENGINEERING);
                case 12 -> ShowResultsInBrowser.showResult(PEOPLE_AND_HR);
                case 13 -> ShowResultsInBrowser.showResult(PRODUCT);
                case 14 -> ShowResultsInBrowser.showResult(QUALITY_ASSURANCE);
                case 15 -> ShowResultsInBrowser.showResult(SALES_AND_BUSINESS_DEVELOPMENT);
                case 16 -> ShowResultsInBrowser.showResult(SOFTWARE_ENGINEERING);
                case 17 -> ShowResultsInBrowser.clearAllFilters();
                case 18 -> {
                    flag = false;
                    log.info("Closing connection...");
                    ShowResultsInBrowser.closeConnection();
                }
                default -> GetResultsForDb.getResults(ACCOUNTING_AND_FINANCE, jobFunction);

            }
        }
    }
}