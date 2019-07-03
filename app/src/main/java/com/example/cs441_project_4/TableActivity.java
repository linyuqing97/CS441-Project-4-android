package com.example.cs441_project_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.Bundle;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        entries = new ArrayList<>();
        entries.add("First");
        entries.add("Second");
        entries.add("Third");
        for (int i = 4; i < 50; i = i + 1)
        {
            entries.add("Row " + i);
        }


        RecyclerView recyclerView =findViewById(R.id.recycle);
        adapter = new RecyclerAdapter(this, entries);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.refreshDrawableState();

    }
}
