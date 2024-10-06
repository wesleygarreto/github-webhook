package com.garreto.githubwebhook.webclient;

import com.garreto.githubwebhook.model.Contributor;
import com.garreto.githubwebhook.model.Issue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;

@Service
public class GitHubClient {

    @Value("${github.url}")
    private String gitHubBaseUrl;
    private final RestTemplate restTemplate;

    public GitHubClient(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Issue> getRepoIssues(final String owner, final String repository) {

        final String url = String.format(gitHubBaseUrl + "repos/%s/%s/issues", owner, repository);
        final ResponseEntity<Issue[]> response = restTemplate.getForEntity(url, Issue[].class);

        return isNull(response.getBody()) ? emptyList() : asList(response.getBody());
    }

    public List<Contributor> getRepoContributors(final String owner, final String repository) {

        final String url = String.format(gitHubBaseUrl + "repos/%s/%s/contributors", owner, repository);
        final ResponseEntity<Contributor[]> response = restTemplate.getForEntity(url, Contributor[].class);

        return isNull(response.getBody()) ? emptyList() : asList(response.getBody());
    }
}