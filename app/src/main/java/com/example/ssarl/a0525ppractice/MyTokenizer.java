package com.example.ssarl.a0525ppractice;

import java.util.StringTokenizer;

public class MyTokenizer {

    public String[] getFoodTokenizer(String text, String s) {
        StringTokenizer st = new StringTokenizer(text, s);
        String[] array = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreElements()) {
            array[i++] = st.nextToken();
        }
        return array;// 배열 던짐
    }
}