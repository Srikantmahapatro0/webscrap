package com.webscrap.webscrap.Configuration;
import com.webscrap.webscrap.Controller.ScrapeController;
import com.webscrap.webscrap.Models.ScrapeRequest;
import com.webscrap.webscrap.Service.Scrapeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Service
public class ScheduleScraping {

    public class ScheduledScrapingService {
        @Autowired
        private ScrapeController sc;

        private final List<String> urls = Arrays.asList("https://example.com", "https://anotherexample.com");
        private final List<String> keywords = Arrays.asList("technology", "innovation");

        @Scheduled(fixedRate = 36000)
        public void schedule() {
            try { sc.scrape(urls.get(0), keywords.get(0)); } catch (IOException e) { e.printStackTrace(); }


        }
    }
}
