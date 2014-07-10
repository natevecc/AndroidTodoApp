package com.example.natevecc.todoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class TodoList extends Activity implements View.OnClickListener {

    private ListView todoListView;
    private EditText input;
    private Button inputButton;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        this.todoListView = (ListView) findViewById(R.id.todoList);
        this.input = (EditText) findViewById(R.id.input);
        this.inputButton = (Button) findViewById(R.id.button);

        String[] values = new String[] {
                "Wake up",
                "Go To work",
                "Build things",
                "Test things",
                "Build Android app",
                "get groceries",
                "make dinner",
                "sleep"
        };

        final ArrayList<String> todos = new ArrayList<String>(Arrays.asList(values));

        this.adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, todos);

        this.todoListView.setAdapter(adapter);
        this.inputButton.setOnClickListener(this);
        this.todoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayAdapter<String> adapter = (ArrayAdapter<String>)adapterView.getAdapter();
                adapter.remove(adapter.getItem(position));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(this.inputButton.isPressed() && this.input.getText().length() > 0) {
            this.adapter.add(this.input.getText().toString());
            this.input.setText(null);
        }
    }
}
