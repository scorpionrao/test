package com.company.challenge.model;

public class HelloModel {

    private String welcomeText;

    public HelloModel() {}

    public HelloModel(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }
}
