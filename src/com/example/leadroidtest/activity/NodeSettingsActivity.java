package com.example.leadroidtest.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.leadroidtest.R;
import com.example.leadroidtest.fragment.NodeSettingsFragment;

public class NodeSettingsActivity extends Activity {
	private NodeSettingsFragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrollview);

		if (savedInstanceState == null) {
			fragment = new NodeSettingsFragment();
			boolean isGoMenuActivity = getIntent().getBooleanExtra(
					NodeSettingsFragment.KEY_IS_GO_MENU, true);
			Bundle bundle = new Bundle();
			bundle.putBoolean(NodeSettingsFragment.KEY_IS_GO_MENU,
					isGoMenuActivity);
			fragment.setArguments(bundle);
			getFragmentManager().beginTransaction()
					.add(R.id.container, fragment).commit();
		}
	}

}
