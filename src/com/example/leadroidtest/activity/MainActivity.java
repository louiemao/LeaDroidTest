package com.example.leadroidtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.leadroidtest.R;
import com.example.leadroidtest.fragment.DataFragment;
import com.example.leadroidtest.fragment.FrequencyFragment;
import com.example.leadroidtest.fragment.NetworkingFragment;
import com.example.leadroidtest.fragment.NodeSettingsFragment;

public class MainActivity extends Activity {
	private FrequencyFragment fragmentFrequency;
	private NetworkingFragment fragmentNetworking;
	private DataFragment fragmentData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrollview);

		if (savedInstanceState == null) {
			fragmentFrequency = new FrequencyFragment();
			fragmentNetworking = new NetworkingFragment();
			fragmentData = new DataFragment();
			getFragmentManager().beginTransaction()
					.add(R.id.container, fragmentFrequency)
					.add(R.id.container2, fragmentNetworking)
					.add(R.id.container3, fragmentData).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(this, NodeSettingsActivity.class);
			intent.putExtra(NodeSettingsFragment.KEY_IS_GO_MENU, false);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
