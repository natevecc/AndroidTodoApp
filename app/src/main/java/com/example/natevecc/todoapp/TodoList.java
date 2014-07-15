package com.example.natevecc.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;


public class TodoList extends Activity implements View.OnClickListener{

    private ListView todoListView;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        this.todoListView = (ListView) findViewById(R.id.todoList);

        if(this.adapter == null) {
            this.adapter = new TodoAdapter(this, new ArrayList<Todo>());
        }

        this.todoListView.setAdapter(adapter);

        Intent intent = this.getIntent();
        if(intent.getStringExtra("title") != null) {
            Date createdAt = new Date();
            long id = this.adapter.getCount();
            Todo newTodo = new Todo(
                    id,
                    intent.getStringExtra("title"),
                    intent.getStringExtra("description"),
                    createdAt);
            this.adapter.add(newTodo);
        }

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
        if (id == R.id.add_todo) {
            Intent intent = new Intent(this, AddTodo.class);
            // Start activity
            this.startActivity(intent);
            // Finish this activity
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
