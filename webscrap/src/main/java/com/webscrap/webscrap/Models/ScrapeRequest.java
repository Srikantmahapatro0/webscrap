package com.webscrap.webscrap.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ScrapeRequest {
    private List<String> urls;
    private List<String> keywords;
    private String schedule;
}



