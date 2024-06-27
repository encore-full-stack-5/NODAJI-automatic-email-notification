package com.example.email.dto;

public class WelcomeMessage {



    public static String makeContents(String certification){
        return ("안녕하세요 NODAJI 입니다.\n"+"인증번호\n"+certification+"\n3분안으로 인증번호를 입력해주세요");
    }

}
