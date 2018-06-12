
package com.example.ssarl.a0525ppractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Food {

    private String name;
    private ArrayList<String> describe = new ArrayList<>();

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    public Food(ArrayList<String> describe) {
        this.describe = describe;
    }
    //오버로딩
    public Food(String name, String[] array) {
        for (int i = 0; i <array.length; i++) {
            this.describe.add(array[i]);
        }
        this.name = name;
    }

    public Food(String name, ArrayList<String> describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDescribe() {
        return describe;
    }

    public void setDescribe(ArrayList<String> describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", describe=" + describe +
                '}';
    }
}
