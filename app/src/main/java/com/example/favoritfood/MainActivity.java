package com.example.favoritfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFood;
    private ArrayList<Food> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFood = findViewById(R.id.rv_food);
        foods = new ArrayList<>();
        foods.add(new Food("Bakso",5,10000,true));
        foods.add(new Food("Ice Cream",5,5000,true));
        foods.add(new Food("Cireng",3.5f,2000,true));
        foods.add(new Food("Bata",1,500,false));
        foods.add(new Food("Warteg",4,9000,true));
        foods.add(new Food("Daun",2,6000,false));
        foods.add(new Food("Seblak",5,15000,true));

        //3 hal yang dibutuhkan agar bisa tampil di Recicler View
        LinearLayoutManager lm = new LinearLayoutManager(this);
        FoodAdapter adapter = new FoodAdapter(this, foods);
        DividerItemDecoration divider = new DividerItemDecoration(this, lm.getOrientation());

        rvFood.setLayoutManager(lm);
        rvFood.setAdapter(adapter);
        rvFood.addItemDecoration(divider);
    }
}
