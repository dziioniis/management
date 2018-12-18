package com.netracker.edu.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentViewModel {
    private long id;
    private String comment;
    private UserViewModel userViewModel;
    private TaskViewModel taskViewModel;
    private String author;
    private String taskId;
    private String date;

}
