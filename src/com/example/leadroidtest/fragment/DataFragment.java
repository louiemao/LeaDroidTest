package com.example.leadroidtest.fragment;

import com.example.leadroidtest.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;

public class DataFragment extends Fragment {
	public RadioButton radioButtonSend;
	public RadioButton radioButtonReceive;
	public TableLayout layoutSend;
	public LinearLayout layoutReceive;
	public Spinner spinnerSpeed;
	public Spinner spinnerDataType;
	public Spinner spinnerBusinessType;
	public Spinner spinnerDiffuseType;
	public EditText editAdress;
	public EditText editSendTimes;
	public EditText editSendInterval;
	public Button buttonSendData;
	public Button buttonSendVoice;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_data, container,
				false);
		radioButtonSend = (RadioButton) rootView
				.findViewById(R.id.radioButtonSend);
		radioButtonReceive = (RadioButton) rootView
				.findViewById(R.id.radioButtonReceive);
		layoutSend = (TableLayout) rootView.findViewById(R.id.layoutSend);
		layoutReceive = (LinearLayout) rootView
				.findViewById(R.id.layoutReceive);
		spinnerBusinessType = (Spinner) rootView
				.findViewById(R.id.spinnerBusinessType);
		buttonSendData = (Button) rootView.findViewById(R.id.buttonSendData);
		buttonSendVoice = (Button) rootView.findViewById(R.id.buttonSendVoice);
		spinnerDataType = (Spinner) rootView.findViewById(R.id.spinnerDataType);

		ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.businessType,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerBusinessType.setAdapter(adapter);
		
		// spinnerBusinessType
		// .setOnItemClickListener(new AdapterView.OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view,
		// int position, long id) {
		// if (position == 0) {
		// spinnerDataType.setEnabled(false);
		// buttonSendData.setEnabled(false);
		// } else {
		// spinnerDataType.setEnabled(true);
		// buttonSendData.setEnabled(true);
		// }
		// if (position == 1 || position == 2) {
		// buttonSendVoice.setEnabled(false);
		// } else {
		// buttonSendVoice.setEnabled(true);
		// }
		// }
		// });

		spinnerBusinessType
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						String str = (String) spinnerBusinessType.getAdapter()
								.getItem((int) id);
						if ("语音".equals(str)) {
							spinnerDataType.setEnabled(false);
							buttonSendData.setEnabled(false);
						} else {
							spinnerDataType.setEnabled(true);
							buttonSendData.setEnabled(true);
						}
						if ("报文".equals(str) || "文件".equals(str)) {
							buttonSendVoice.setEnabled(false);
						} else {
							buttonSendVoice.setEnabled(true);
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

		radioButtonSend
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							radioButtonReceive.setChecked(false);
							layoutSend.setVisibility(View.VISIBLE);
							layoutReceive.setVisibility(View.GONE);
						} else {
							radioButtonReceive.setChecked(true);
							layoutSend.setVisibility(View.GONE);
							layoutReceive.setVisibility(View.VISIBLE);
						}
					}
				});

		radioButtonReceive
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							radioButtonSend.setChecked(false);
							layoutSend.setVisibility(View.GONE);
							layoutReceive.setVisibility(View.VISIBLE);
						} else {
							radioButtonSend.setChecked(true);
							layoutSend.setVisibility(View.VISIBLE);
							layoutReceive.setVisibility(View.GONE);
						}
					}
				});
		radioButtonSend.setChecked(true);
		return rootView;
	}
}
