package com.example.email.dto;

public enum EmailEnum {

    WELCOME("환영합니다. NODAJI 사이트입니다."),
    CONGRATULATIONS("축하드립니다. NODAJI 사이트입니다.");

    private final String title;

    EmailEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}