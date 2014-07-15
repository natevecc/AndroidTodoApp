package com.example.natevecc.todoapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by natevecc on 7/15/14.
 */
public class TodoAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Todo> todos;
    private static LayoutInflater inflater=null;

    public TodoAdapter(Activity activity, ArrayList<Todo> todos) {
        this.activity = activity;
        this.todos = todos;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.todos.size();
    }

    @Override
    public Object getItem(int i) {
        return this.todos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.todos.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.todo_item, null);

        TextView title = (TextView)vi.findViewById(R.id.todo_title); // title
        TextView created = (TextView)vi.findViewById(R.id.todo_created); // artist name
        TextView description = (TextView)vi.findViewById(R.id.todo_description); // duration

        Todo todo = todos.get(position);

        // Setting all values in listview
        title.setText(todo.getTitle());
        created.setText(todo.getCreatedAt().toString());
        description.setText(todo.getDescription());
        return vi;
    }

    public void add(Todo todo) {
        this.todos.add(todo);
    }
}
