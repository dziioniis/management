package com.netracker.edu.fapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    @JsonProperty("content")
    ProjectViewModel[]projectViewModels ;
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
