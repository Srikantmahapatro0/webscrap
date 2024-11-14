package com.webscrap.webscrap.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
private String prefix;
private int limit;
}

