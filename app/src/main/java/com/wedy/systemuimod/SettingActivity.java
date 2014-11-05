package com.wedy.systemuimod;

import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;


public class SettingActivity extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingFragment()).commit();
	}

	
	public static class SettingFragment extends PreferenceFragment{
		
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.settings);
			if(Build.VERSION.SDK_INT >= 19) {
				PreferenceScreen prefScreen = getPreferenceScreen();
				CheckBoxPreference checkboxPreference = 
				(CheckBoxPreference)prefScreen.findPreference("key_tranz1");
				CheckBoxPreference checkboxPreference2 = 
				(CheckBoxPreference)prefScreen.findPreference("key_transjpn");
				checkboxPreference.setEnabled(false);
				checkboxPreference2.setEnabled(false);

			}
			
		}
	}
	
}
