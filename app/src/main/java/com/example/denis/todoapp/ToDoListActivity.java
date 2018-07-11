package com.example.denis.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        Intent caller = getIntent();
        String name = caller.getStringExtra("name");
        TextView nameTextView = (TextView) findViewById(R.id.textView_name);
        nameTextView.setText("Welcome "+ name + "! Here is your to do list");


    }

    public void createItem(View view) {
        EditText itemEditText = (EditText) findViewById(R.id.editText_item);
        String item = itemEditText.getText().toString();
        LinearLayout listLinearLayout = (LinearLayout) findViewById(R.id.linearLayout_list);

        final CheckBox checkBox = new CheckBox(this);
        checkBox.setText(item);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(checkBox.isChecked()){
                   Toast.makeText(getApplicationContext(),
                           checkBox.getText().toString() + " checked",
                           Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(),
                           checkBox.getText().toString() + " unchecked",
                           Toast.LENGTH_SHORT).show();
               }
            }
        });
        listLinearLayout.addView(checkBox);

        itemEditText.setText("");
        Toast.makeText(getApplicationContext(),item+ " created", Toast.LENGTH_SHORT).show();
    }
}