package com.example.flowering_ex;

import android.os.Bundle;


import androidx.preference.PreferenceFragmentCompat;

public class SettingFragment extends PreferenceFragmentCompat {

    public static SettingFragment newInstance() { return new SettingFragment(); }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences,rootKey);
    }
}
