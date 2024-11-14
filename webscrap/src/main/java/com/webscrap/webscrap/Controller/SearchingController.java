package com.webscrap.webscrap.Controller;
import com.webscrap.webscrap.Models.SearchRequest;
import com.webscrap.webscrap.Models.StatusResponse;
import com.webscrap.webscrap.Service.Searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/api/v1")
    public class SearchingController {
        @Autowired
        private Searchservice.Trie trie;
        @PostMapping("/search")
        public ResponseEntity<List<String>> search(@RequestBody SearchRequest request) {
            List<String> results = trie.autocomplete(request.getPrefix());
            return ResponseEntity.ok(results);
        }

        @GetMapping("/status/{jobId}")
        public ResponseEntity<StatusResponse> getStatus(@PathVariable String jobId) {
            // Mocked response for example
            StatusResponse response = new StatusResponse("completed", jobId, List.of("url1", "url2"), List.of("keyword1", "keyword2"), "2 MB", "2024-11-01T10:15:00Z");
            return ResponseEntity.ok(response);
        }
    }

