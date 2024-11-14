package com.webscrap.webscrap.Controller;
import com.webscrap.webscrap.Service.Scrapeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScrapeController {
    @Autowired
        private Scrapeservice scrapeservice;

        @PostMapping("/scrape")
        public ResponseEntity<List<String>> scrape(@RequestParam String url, @RequestParam String keyword) throws IOException {
            List<String> data = scrapeservice.scrapeData(url, keyword);
            return ResponseEntity.ok(data);
        }
    }

