package com.example.sequencecalculator;
/*
Intent intent = new Intent(this, SecondActivity.class);
intent.putExtra("test", 123);
startActivity(intent);
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton seq;
    EditText first, diff;
    int item, d;
    boolean isArithmetic;
    String[] list = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seq = findViewById(R.id.seq);
        first = findViewById(R.id.first);
        diff = findViewById(R.id.diff);
    }

    public void onClick(View view) {
        isArithmetic = seq.isChecked();
        String str1 = first.getText().toString();
        item = Integer.parseInt(str1);
        String str2 = diff.getText().toString();
        d = Integer.parseInt(str2);
        list[0] = String.valueOf(item);
        if (isArithmetic)
            for (int i = 1; i < list.length; i++)
                list[i] = String.valueOf(item + i * d);
        else
            for (int i = 1; i < list.length; i++)
                list[i] = String.valueOf(item * (int) Math.pow(d, i));
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("sequence", isArithmetic);
        intent.putExtra("firstItem", item);
        intent.putExtra("difference", d);
        intent.putExtra("itemList", list);

        startActivity(intent);
    }
}