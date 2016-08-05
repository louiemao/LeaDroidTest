package com.example.leadroidtest;

import android.app.Application;
import android.preference.PreferenceManager;

public class MyApplication extends Application {
	private static final String KEY_FREQUENCY = "Frequency";

	private static MyApplication instance;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static MyApplication getInstance() {
		return instance;
	}

	public void setFrequency(float[] frequency) {
		StringBuilder sb = new StringBuilder();
		if (frequency != null && frequency.length > 0) {
			for (int i = 0; i < frequency.length; i++) {
				sb.append(frequency[i]);
				if (i != frequency.length - 1) {
					sb.append(",");
				}
			}
		}
		PreferenceManager.getDefaultSharedPreferences(this).edit()
				.putString(KEY_FREQUENCY, sb.toString()).commit();
	}

	public float[] getFrequency() {
		String str = PreferenceManager.getDefaultSharedPreferences(this)
				.getString(KEY_FREQUENCY, null);
		if (str == null) {
			return null;
		}
		String[] strs = str.split(",");
		float[] frequency = new float[strs.length];
		for (int i = 0; i < strs.length; i++) {
			frequency[i] = Float.parseFloat(strs[i]);
		}
		return frequency;
	}

}
