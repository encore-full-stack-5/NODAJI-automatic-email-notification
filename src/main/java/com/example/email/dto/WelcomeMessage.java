package com.example.email.dto;

public class WelcomeMessage {

    public static final String TITLE = "환영합니다. NODAJI 사이트입니다.";

    public static String makeContents(String certification){
        return ("안녕하세요 NODAJI 입니다.\n"+"인증번호\n"+certification+"\n1분안으로 인증번호를 입력해주세요");
    }

}
