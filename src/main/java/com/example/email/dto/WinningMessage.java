package com.example.email.dto;

public class WinningMessage {



    public static String makeContents(String name, String game, int rank,int round){
//        return ("안녕하세요 "+name+"님,\n"+game+", "+rank+"등에 되셨습니다.");

        return ("안녕하세요 "+name+"님,\n이번 주 "+game+", "+round+"회차에 당첨되셨습니다.\n"+"자세한 등수는 사이트 방문하여 확인해 주세요.");

    }



}
