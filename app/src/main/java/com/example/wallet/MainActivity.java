package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wallet.adapter.RecyclerAdapter;
import com.example.wallet.model.Updates;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    RecyclerAdapter recyclerAdapter;
    LinearLayout menuCar,menuFood,menuBill,menuTelevision,menuEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.logo);

        menuCar = findViewById(R.id.menu_car);
        menuFood = findViewById(R.id.menu_food);
        menuBill = findViewById(R.id.menu_bill);
        menuTelevision = findViewById(R.id.menu_television);
        menuEducation = findViewById(R.id.menu_education);

        menuCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Car.class);
                startActivity(myIntent);
            }
        });

        menuFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage("Menu Food is Clicked");
            }
        });

        ArrayList<Updates> updatesList = new ArrayList<>();
        updatesList.add(new Updates(R.drawable.vacation,"Planning vacation?","19/11/2023"));
        updatesList.add(new Updates(R.drawable.coffee,"Wanna drink Coffee?","18/11/2023"));
        updatesList.add(new Updates(R.drawable.car_rent,"Take 10% off for car rent?","13/11/2023"));
        updatesList.add(new Updates(R.drawable.clothes,"Buy new Clothes","10/11/2023"));

        recyclerView = findViewById(R.id.recycler_view);
        recyclerAdapter = new RecyclerAdapter(updatesList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerAdapter);


    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}