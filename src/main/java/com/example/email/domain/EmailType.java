package com.example.email.domain;


public enum EmailType {
    WELCOME("첫방문", "안녕하세요 {name}님, 노다지사이트를 이용해주셔서 감사합니다.{certification} 인증번호를 입력해주세요"),
    WINNING("당첨", "안녕하세요 {name}님, {game}에 {rank}등 되셨습니다.");

    private final String subject;
    private final String bodyTemplate;

    EmailType(String subject, String bodyTemplate) {
        this.subject = subject;
        this.bodyTemplate = bodyTemplate;
    }

    public String getSubject() {
        return subject;
    }

    public String getBodyTemplate() {
        return bodyTemplate;
    }
}
