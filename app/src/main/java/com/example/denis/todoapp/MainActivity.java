package com.example.denis.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startCreatingList(View view) {
        String name = (((EditText) findViewById(R.id.editText_name)).getText()).toString();
        Intent goToSecond = new Intent();
        goToSecond.setClass(this,ToDoListActivity.class);
        goToSecond.putExtra("name", name);
        startActivity(goToSecond);
    }
}
