package com.netracker.edu.fapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    @JsonProperty("content")
    TaskViewModel[]taskViewModels ;
    private Pageable pageable;
    private int totalElements;
    private int totalPages;
    boolean last;
    private int size;
    private int number;
    private int numberOfElements;
    boolean first;
    Sort sort;

}

