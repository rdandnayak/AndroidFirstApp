package com.todo.androidtodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    private static final String ACTIVITY_TITLE = "Edit Todo";
    private EditText etEditItem;
    private int editItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        getSupportActionBar().setTitle(ACTIVITY_TITLE);
        String editItemText = getIntent().getStringExtra("todoItem");
        editItemIndex = getIntent().getIntExtra("todoIndex", -1);
        etEditItem = (EditText) findViewById(R.id.etEditTodoField);
        populateEditText(editItemText);
    }

    private void populateEditText(String editItemText) {
        etEditItem.setText(editItemText);
        etEditItem.setSelection(editItemText.length());
        etEditItem.requestFocus();
        // Set keyboard to appear after etEditItem is in focus
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public void onSave(View view) {
        final String editedText = etEditItem.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("todoItem", editedText);
        intent.putExtra("todoIndex", editItemIndex);
        setResult(RESULT_OK, intent);
        finish();
    }
}
