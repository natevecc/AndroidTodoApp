package com.example.natevecc.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.natevecc.todoapp.R;

public class AddTodo extends Activity implements View.OnClickListener {

    private EditText input;
    private Button inputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        this.input = (EditText)this.findViewById(R.id.editText);
        this.inputButton = (Button)this.findViewById(R.id.button);
        this.inputButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_todo, menu);
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
            Intent intent = new Intent(this, TodoList.class);
            intent.putExtra("todo", this.input.getText().toString());
            startActivity(intent);
            this.finish();
            this.input.setText(null);
        }
    }
}
