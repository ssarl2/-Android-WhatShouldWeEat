package com.example.ssarl.a0525ppractice;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class FoodRecomendor {


    private CreateDB db;

    private List<Food> foods;

    private Random random;


    public FoodRecomendor(CreateDB db)
    {
        this.db = db;
        random = new Random();
        newRecomend();
    }


    public void newRecomend()
    {
        foods = db.getInfos();
    }


    public String getRandomDescribe() {
        HashSet<String> describe = new HashSet<>();
        for (Food food : foods) {
            for (String des : food.getDescribe()) {
                if (!describe.contains(des)) {
                    describe.add(des);
                }
            }
        }
        int idx = random.nextInt(describe.size());
        int count = 0;
        for (String des : describe)
        {
            if(count == idx)
                return des;
            count +=1;
        }
        return "";
    }
//

    public void filt(String describe, boolean answer)
    {
        for (int i = foods.size() - 1 ; i >= 0 ; i -=1 ) {
            Food food = foods.get(i);
            boolean isContain = false;
            for (String des : food.getDescribe()) {
                isContain |= describe.equals(des);
            }
            // true  false -> 삭제
            // false true  -> 삭제
            if(isContain != answer)
            {
                foods.remove(i);
            }
        }
    }

    public List<Food> getFoods() {
        return foods;
    }

    public int getSize()
    {
        return foods.size();
    }
}
