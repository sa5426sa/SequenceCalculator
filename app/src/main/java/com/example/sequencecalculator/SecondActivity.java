package com.example.sequencecalculator;
/*
int test = getIntent().getIntExtra("test", 0);
Toast.makeText(this, "test = " + test, Toast.LENGTH_SHORT).show();
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    ListView items;
    TextView conText;
    int place = 0;
    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        boolean sequence = getIntent().getBooleanExtra("sequence", false);
        int firstItem = getIntent().getIntExtra("firstItem", 0);
        int difference = getIntent().getIntExtra("difference", 1);
        String[] itemList = getIntent().getStringArrayExtra("itemList");

        list = itemList;

        items = findViewById(R.id.items);
        conText = findViewById(R.id.conText);

        items.setOnItemLongClickListener(this);
        items.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, itemList);
        items.setAdapter(adp);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        place = position;
        items.setOnCreateContextMenuListener(this);
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Show n");
        menu.add("Show sum (X1 -> Xn)");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String op = item.getTitle().toString();
        if (op.equals("Show n"))
            conText.setText("n = " + (place + 1));
        else {
            int sum = 0;
            for (int i = 0; i <= place; i++)
                sum += Integer.parseInt(list[i]);
            conText.setText("Sn = " + sum);
        }

        return super.onContextItemSelected(item);
    }
}