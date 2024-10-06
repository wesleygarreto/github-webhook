package com.garreto.githubwebhook.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"user", "repository", "issues", "contributors"})
public class WebhookPayload {

    private final String user;
    private final String repository;
    private final List<Issue> issues;
    private final List<Contributor> contributors;
}
