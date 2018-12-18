package com.netracker.edu.fapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pageable {
    private int offset;
    int pageSize;
    int pageNumber;
    boolean unpaged;
    boolean paged;
    Sort sort;
}

