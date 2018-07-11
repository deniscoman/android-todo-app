package com.example.denis.todoapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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

import java.lang.invoke.ConstantCallSite;
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
        nameTextView.setText(getString(R.string.welcome)+" " + name+ "! " + getString(R.string.message));


    }

    public void createItem(View view) {
        EditText itemEditText = (EditText) findViewById(R.id.editText_item);
        String item = itemEditText.getText().toString();
        LinearLayout linearLayoutList = (LinearLayout) findViewById(R.id.linearLayout_list);

        final CheckBox checkBox = new CheckBox(this);
        checkBox.setText(item);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(checkBox.isChecked()){
                   Toast.makeText(getApplicationContext(),
                           checkBox.getText().toString() +" "+ getString(R.string.checked),
                           Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(),
                           checkBox.getText().toString() +" "+ getString(R.string.unchecked),
                           Toast.LENGTH_SHORT).show();
               }
            }
        });
        linearLayoutList.addView(checkBox);

        itemEditText.setText("");
        Toast.makeText(getApplicationContext(),item+ " " + getString(R.string.created), Toast.LENGTH_SHORT).show();
    }
}
