package com.example.expandablerecyclerviewex;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.expandablerecyclerviewex.Adapter.NewspaperAdapter;
import com.example.expandablerecyclerviewex.Utils.JsonHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView)this.findViewById(R.id.recyclerViewId);
        NewspaperAdapter adapter = new NewspaperAdapter((Context)this, (new JsonHelper((Context)this)).getNewsPaperData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new LinearLayoutManager((Context)this)));

    }
}
