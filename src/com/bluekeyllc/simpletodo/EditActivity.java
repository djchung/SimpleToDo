package com.bluekeyllc.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
		String itemToEdit = getIntent().getStringExtra("item");
		EditText etItem = (EditText)findViewById(R.id.etTodoItem);
		etItem.setText(itemToEdit);
		etItem.setSelection(itemToEdit.length());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}
	
	public void saveItem(View v) {
		EditText etItem = (EditText)findViewById(R.id.etTodoItem);
		Intent data = new Intent();
		data.putExtra("editedTodoItem", etItem.getText().toString());
		setResult(RESULT_OK, data);
		this.finish();
	}

}
