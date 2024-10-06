package com.garreto.githubwebhook.service;

import com.garreto.githubwebhook.model.Contributor;
import com.garreto.githubwebhook.model.Issue;
import com.garreto.githubwebhook.model.WebhookPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AsyncWebhookService {

    @Value("${threads.wait.duration}")
    private int defaultWaitDuration;

    @Async
    public void sendData(final String webhookUrl, final String user, final String repository, final List<Issue> issues, final List<Contributor> contributors) throws InterruptedException {

        Thread.sleep(defaultWaitDuration);

        final WebhookPayload webhookPayload = new WebhookPayload(user, repository, issues, contributors);

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(webhookUrl, webhookPayload, String.class);
    }
}
