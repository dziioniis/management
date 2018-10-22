package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectViewModel {
    private Long id;

    @Override
    public String toString() {
        return "ProjectViewModel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    private String code;
    private String summary;

    public ProjectViewModel() {
    }

    public ProjectViewModel(String code, String summary) {
        this.code = code;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
