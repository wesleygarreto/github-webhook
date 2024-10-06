package com.garreto.githubwebhook.resource;

import com.garreto.githubwebhook.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class GitHubResource {

    private final GithubService githubService;

    @Autowired
    public GitHubResource(final GithubService githubService) {
        this.githubService = githubService;
    }

    @PostMapping("/search-data")
    public ResponseEntity<String> fetchIssues(
            @RequestParam final String user,
            @RequestParam final String repository,
            @RequestParam final String webhookUrl) throws InterruptedException {

        githubService.searchAndSendData(user, repository, webhookUrl);

        return ResponseEntity.ok("Data search programmed and will be sent at the configured time.");
    }
}