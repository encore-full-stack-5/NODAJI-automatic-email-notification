package com.example.email.dto;

public class WinningMessage {

    public static final String TITLE = "축하드립니다. NODAJI 사이트입니다.";

    public static String makeContents(String name, String game, int rank){
        return ("안녕하세요 "+name+"님,\n"+game+"에"+rank+"등 되셨습니다.");
    }
}
