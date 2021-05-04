package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ToDo> works=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.add);
        works.add(new ToDo("I wanna go outside at 6:00 pm today",false));
        CustomAdapter ca=new CustomAdapter(this,works);
        bt.setOnClickListener(v -> {
            TextView tv=findViewById(R.id.newitem);
            ToDo newWork=new ToDo(tv.getText().toString(),false);
            works.add(newWork);
            tv.setText("");
            ca.notifyDataSetChanged();
        });
        RecyclerView rv=findViewById(R.id.recycle);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(ca);

    }
}