package com.example.email.dto;

public class EmailType {

    public static String welcomeSubject(){
        return "환영합니다. NODAJI 사이트입니다.";
    }

    public static String winningSubject(){
        return "축하드립니다. NODAJI 사이트입니다.";
    }

    public static String makeWelcomeMessage(String certification){
        return ("안녕하세요 NODAJI 입니다.\n"+"인증번호\n"+certification+"\n1분안으로 인증번호를 입력해주세요");
    }

    public static String makeWinningMessage(String name, String game, int rank){
        return ("안녕하세요 "+name+"님,\n"+game+"에"+rank+"등 되셨습니다.");
    }



}
