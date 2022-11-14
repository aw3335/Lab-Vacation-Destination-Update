package com.hfad.vacationdestination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        RecyclerView rv = findViewById(R.id.recyclerView);

        //adapter
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        rv.setAdapter(adapter);

        //Manager connects the above two
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);
    }
}