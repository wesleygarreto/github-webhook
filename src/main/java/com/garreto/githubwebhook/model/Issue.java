package com.garreto.githubwebhook.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"title", "author", "labels"})
public class Issue {

    private String title;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    private List<Label> labels;

    @JsonSetter
    public String getAuthor() {
        return user.getLogin();
    }

    @JsonSetter
    public List<String> getLabels() {

        final List<String> labelList = new ArrayList<>();
        this.labels.forEach(label -> labelList.add(label.getName()));

        return labelList;
    }
}