package com.todo.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etWords;
    private TextView tvLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWords = (EditText) findViewById(R.id.etWords);
        tvLabel = (TextView) findViewById(R.id.tvLabel);
    }

    public void onSubmit(View view) {
        String fieldValue = etWords.getText().toString();
        tvLabel.setText(fieldValue);
        Toast.makeText(this, fieldValue, Toast.LENGTH_SHORT).show();
    }
}
