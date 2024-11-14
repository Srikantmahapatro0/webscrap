package com.webscrap.webscrap.Configuration;
import com.webscrap.webscrap.Service.Scrapeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
public class ScheduleScraping {
    @Service
    public class ScheduledScrapingService {
        @Autowired
        private Scrapeservice webScrapingService;

        @Scheduled(fixedRate = 3600000)  // Every hour
        public void scheduleScraping() {

            // Add logic to retrieve URLs and keywords from storage
            // Example: webScrapingService.scrapeData(url, keyword);
        }
    }


}
