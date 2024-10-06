package com.garreto.githubwebhook.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contributor {

    @JsonSetter("user")
    private String login;

    @JsonSetter("qtd_commits")
    private int contributions;
}