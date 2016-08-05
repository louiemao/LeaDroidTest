package com.example.leadroidtest.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.leadroidtest.R;
import com.example.leadroidtest.activity.FrequencyListActivity;

public class FrequencyFragment extends Fragment {
	public Button btnList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_frequency,
				container, false);
		btnList = (Button) rootView.findViewById(R.id.btnList);

		btnList.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), FrequencyListActivity.class);
				startActivity(intent);
			}
		});
		return rootView;
	}
}
