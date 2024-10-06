package com.garreto.githubwebhook.service;

import com.garreto.githubwebhook.model.Contributor;
import com.garreto.githubwebhook.model.Issue;
import com.garreto.githubwebhook.webclient.GitHubClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubService {

    private final GitHubClient gitHubClient;
    private final AsyncWebhookService asyncWebhookService;

    public GithubService(final GitHubClient gitHubClient, final AsyncWebhookService asyncWebhookService) {
        this.gitHubClient = gitHubClient;
        this.asyncWebhookService = asyncWebhookService;
    }

    public void searchAndSendData(final String user, final String repository, final String webhookUrl) throws InterruptedException {

        final List<Issue> issues = gitHubClient.getRepoIssues(user, repository);
        final List<Contributor> contributors = gitHubClient.getRepoContributors(user, repository);

        asyncWebhookService.sendData(webhookUrl, user, repository, issues, contributors);
    }
}
