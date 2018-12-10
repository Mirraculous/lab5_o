package com.example.dmsha.lab5_o;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RV;
    ad adapter;
    ArrayList<event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        events = new ArrayList<>();

        events.add(new event("kek", "comm", true, 2018, 6, 20));
        events.add(new event("kek2", "", false, 2018, 1, 22));
        events.add(new event("some stupid shiiiit", "so fckn hate zaharov", false, 2019, 1, 22));

        RV = findViewById(R.id.RV);
        adapter = new ad(events);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RV.setLayoutManager(layoutManager);
        RV.setAdapter(adapter);


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        Spinner s = (Spinner) menu.findItem(R.id.spinner).getActionView();
        ArrayAdapter aad = ArrayAdapter.createFromResource(this,
                R.array.options_array, R.layout.support_simple_spinner_dropdown_item);
        s.setAdapter(aad);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
