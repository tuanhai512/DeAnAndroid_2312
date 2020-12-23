package com.example.doanltdd.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.doanltdd.Detail;
import com.example.doanltdd.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MyList extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ListView listView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_ex);
        imageView = findViewById(R.id.image);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.info) {
                    Toast.makeText(getApplicationContext(), "Thông tin", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.setup) {
                    Toast.makeText(getApplicationContext(), "Cài đặt", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
        acctionToolBar();

        listView = findViewById(R.id.listView);
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Adominal Crunch",R.drawable.abs));
        contacts.add(new Contact("Bicycle Crunches",R.drawable.abs));
        contacts.add(new Contact("Crossarm Crunches",R.drawable.abs));
        contacts.add(new Contact("Flutter Kick",R.drawable.abs));
        contacts.add(new Contact("Long Arm Crunch",R.drawable.abs));
        contacts.add(new Contact("Heel Touch",R.drawable.abs));
        contacts.add(new Contact("Russian Twist",R.drawable.abs));
        contacts.add(new Contact("Scissors",R.drawable.abs));
        contacts.add(new Contact("Straight Arm Plank",R.drawable.abs));
        contacts.add(new Contact("Toy Sloiders",R.drawable.abs));
        MyAdapter myAdapter = new MyAdapter(this,R.layout.activity_list_row_ex,contacts);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra("name","Adominal Crunch");
                    intent.putExtra("noidung", getString(R.string.adominalcrunch));
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra("name","Bicycle Crunch");
                    intent.putExtra("noidung", getString(R.string.bicyclecrunch));
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
                if(position==7) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
                if(position==8) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
                if(position==9) {
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    startActivity(intent);
                }
            }
        });
    }


    private void acctionToolBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}

