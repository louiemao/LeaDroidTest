package com.example.leadroidtest.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leadroidtest.MyApplication;
import com.example.leadroidtest.R;

public class FrequencyListActivity extends Activity {
	private List<EditText> editTextList = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
		float[] arrays = MyApplication.getInstance().getFrequency();
		for (int i = 0; i < 24; i++) {
			LinearLayout subLayout = new LinearLayout(this);
			TextView textView1 = new TextView(this);
			EditText editText = new EditText(this);
			TextView textView2 = new TextView(this);

			textView1.setText(String.valueOf(i + 1));
			textView2.setText("MHz");
			if (arrays != null && arrays.length > i) {
				editText.setText(String.valueOf(arrays[i]));
			}
			editText.setInputType(InputType.TYPE_CLASS_NUMBER
					| InputType.TYPE_NUMBER_FLAG_DECIMAL);
			editTextList.add(editText);

			subLayout.addView(textView1,
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, 1);
			subLayout.addView(editText, params);
			subLayout.addView(textView2,
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			layout.addView(subLayout, LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_save) {
			save();
			Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void save() {
		if (editTextList.size() == 0) {
			return;
		}
		float[] array = new float[editTextList.size()];
		for (int i = 0; i < editTextList.size(); i++) {
			Editable text = editTextList.get(i).getText();
			if (TextUtils.isEmpty(text)
					|| TextUtils.isEmpty(text.toString().trim())) {
				array[i] = 0;
			}
			array[i] = Float.parseFloat(text.toString().trim());
			if (array[i] < 400) {
				array[i] = 400;
			} else if (array[i] > 678) {
				array[i] = 678;
			}
			editTextList.get(i).setText(String.valueOf(array[i]));
		}
		MyApplication.getInstance().setFrequency(array);
	}

}
