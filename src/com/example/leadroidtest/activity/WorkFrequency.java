package com.example.leadroidtest.activity;

import com.example.leadroidtest.R;
import com.example.leadroidtest.fragment.FrequencyFragment;

import android.app.Activity;
import android.os.Bundle;

public class WorkFrequency extends Activity{
	private FrequencyFragment frequencyFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrollview);
		
		if(savedInstanceState == null){
			frequencyFragment = new FrequencyFragment();
			getFragmentManager().beginTransaction().add(R.id.container, frequencyFragment).commit();
		}
	}
}
