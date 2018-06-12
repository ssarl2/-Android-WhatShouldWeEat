package com.example.ssarl.a0525ppractice;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateDB extends SQLiteOpenHelper{



    private Context context;
    public CreateDB(Context context) {
        super(context, "food", null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //★★★★★ 별 많이!! 아주 중요
        ArrayList<Food> foodList = new ArrayList();
        //제네릭Food를 달아 줌으로써 Food형이 되어 getName 메소드등을 쓸수있다.
        //달지 않으면 기본으로 Object형이 되어 Object의 기능,
        //예를들면 toString등의 기본적인 기능들을 쓰게 된다.
        String[] foodAndDescribe;
        String[] descrbieArray;


        try {
            InputStream is = context.getAssets().open("Foods.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while((line = br.readLine()) != null)
            {
                MyTokenizer myTokenizer = new MyTokenizer();

                //배열 받아서 ArrayList에 넣음
                foodAndDescribe = myTokenizer.getFoodTokenizer(line, "\t"); //foodAndDescribe 배열 0번은 음식이름 1번은 음식 특징들
                descrbieArray = myTokenizer.getFoodTokenizer(foodAndDescribe[1], ","); //descrbieArray 배열에 음식 특징들 나열

                foodList.add(new Food(foodAndDescribe[0], descrbieArray)); //foodList ArrayList에 음식이름과 특징 ArrayList를 넣음

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 테이블 생성
        db.execSQL("DROP TABLE IF EXISTS FOOD;");
        db.execSQL("CREATE TABLE FOOD (name,describe,PRIMARY KEY(name,describe));");

        // 데이터 삽입
        for (int i = 0; i < foodList.size(); i++) {
            for (int j = 0; j < foodList.get(i).getDescribe().size(); j++) {
                db.execSQL(String.format("INSERT INTO FOOD(name,describe) " +
                        "VALUES(\"%s\", \"%s\");", foodList.get(i).getName(), foodList.get(i).getDescribe().get(j)));
            }
        }

    }

    // 데이터 읽기
    public List<Food> getInfos() {
        // 읽기 위해서 읽기용으로 데이터베이스를 연다
        SQLiteDatabase db = getReadableDatabase();

        // 데이터를 가져오기 위한 쿼리 메소드
        Cursor cursor = db.rawQuery("SELECT * FROM FOOD", null);

        List<Food> results = new ArrayList<Food>();
        HashMap<String, List<String>> bindInfo = new HashMap<>();

        // 결과의 모든 행 끝까지 반복
        while(cursor.moveToNext())
        {
            String key = cursor.getString(0);
            if(!bindInfo.containsKey(key))
            {
                bindInfo.put(key, new ArrayList<String>());
            }
            List<String> list =  bindInfo.get(key);
            list.add(cursor.getString(1));

        }

        for(String key : bindInfo.keySet())
        {
            results.add(new Food(key, (ArrayList)bindInfo.get(key)));
        }

        // 데이터베이스 사용후에는 꼭 닫아야 한다.
        db.close();

        return results;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
