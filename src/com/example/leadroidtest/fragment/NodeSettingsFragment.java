package com.example.leadroidtest.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.leadroidtest.R;
import com.example.leadroidtest.activity.MenuActivity;

public class NodeSettingsFragment extends Fragment {
	public static final String KEY_IS_GO_MENU = "KEY_IS_GO_MENU";

	public Spinner spinnerLevelType;
	public EditText editSerial0;
	public EditText editSerial1;
	public EditText editSerial2;
	public EditText editSerial3;
	public EditText editSerial4;
	public EditText editGroupId;
	public Spinner spinnerNodeType;
	public Button btnSetting;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_node_settings,
				container, false);
		spinnerLevelType = (Spinner) rootView
				.findViewById(R.id.spinnerLevelType);
		editSerial0 = (EditText) rootView.findViewById(R.id.editSerial0);
		editSerial1 = (EditText) rootView.findViewById(R.id.editSerial1);
		editSerial2 = (EditText) rootView.findViewById(R.id.editSerial2);
		editSerial3 = (EditText) rootView.findViewById(R.id.editSerial3);
		editSerial4 = (EditText) rootView.findViewById(R.id.editSerial4);
		editGroupId = (EditText) rootView.findViewById(R.id.editGroupId);
		spinnerNodeType = (Spinner) rootView.findViewById(R.id.spinnerNodeType);
		btnSetting = (Button) rootView.findViewById(R.id.btnSetting);

		btnSetting.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean isGoMenuActivity = getArguments().getBoolean(
						KEY_IS_GO_MENU);
				if (isGoMenuActivity) {
					startActivity(new Intent(getActivity(), MenuActivity.class));
				}
				getActivity().finish();
			}
		});

		return rootView;
	}
}
