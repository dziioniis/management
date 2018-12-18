package com.netracker.edu.fapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ProjectViewModel {
    private Long id;
    private String code;
    private String summary;
    private String author;
    private String createdDate;
    private String closed;
    private String status;
}
