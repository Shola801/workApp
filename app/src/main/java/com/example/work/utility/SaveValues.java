package com.example.work.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.work.R;

public class  SaveValues {

    private Context myContext;


    public SaveValues(Context myContext) {
        if (myContext == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        this.myContext = myContext;
    }

    public void clearPrefValue(String prefKey) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.remove(prefKey);
        myEditor.apply();
    }

    public void saveStringPrefValue(String prefKey, String value) {
        SharedPreferences mySharedPreferences = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.putString(prefKey, value);
        myEditor.apply();
    }

    public  void saveIntPrefValue(String prefKey, int value) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putInt(prefKey, value);
        myEditor.apply();
    }

    public  void saveLongPrefValue(String prefKey, long value) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putLong(prefKey, value);
        myEditor.apply();
    }

    public  void saveBooleanPrefValue(String prefKey, boolean value) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putBoolean(prefKey, value);
        myEditor.apply();
    }

    public  String getStringPrefValue(String prefKey) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        return  mySharedPreference.getString(prefKey, null);

    }

    public int getIntPrefValue(String prefKey) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        return mySharedPreference.getInt(prefKey,0);

    }

    public long getLongPrefValue(String prefKey) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        return mySharedPreference.getLong(prefKey,0);

    }

    public boolean getBooleanPrefValue(String prefKey) {
        SharedPreferences mySharedPreference = myContext.getSharedPreferences(myContext.getString(R.string.myPref), Context.MODE_PRIVATE);
        return mySharedPreference.getBoolean(prefKey,false);

    }

}