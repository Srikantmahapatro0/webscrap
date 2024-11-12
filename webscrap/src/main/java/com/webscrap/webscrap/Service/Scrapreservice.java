package com.webscrap.webscrap.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Scrapreservice {
    public List<String> scrapeData(String url, String keyword) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsContainingText(keyword);
        List<String> data = new ArrayList<>();

        elements.forEach(element -> data.add(element.text()));

        return data;
    }
}

