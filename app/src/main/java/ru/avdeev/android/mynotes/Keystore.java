package ru.avdeev.android.mynotes;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.prefs.Preferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;

public interface Keystore {

    public final static String KEY = "key1";
    public final static String PIN_CODE = "pin_cod";

    default boolean hasPin() {
        File f = new File("/data/data/ru.avdeev.android.mynotes/shared_prefs/ru.avdeev.android.mynotes_preferences.xml");
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    default boolean checkPin(String pinCode) {
        if (hasPin() && pinCode.equals(loadPinCode())) {
            return true;
        } else {
            return false;
        }
    }

    default void savePinCode(String pinCode) {
        SharedPreferences preferences =  PreferenceManager.getDefaultSharedPreferences((Context) this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY,pinCode).commit();
        Toster.showMyMessage(R.string.new_pin_saved,(Context) this);
    }

    default String loadPinCode() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences((Context) this);
        return preferences.getString(KEY,"");
    }


    /*public final static String KEY = "key1";
    public final static String PIN_CODE = "pin_cod";

    public default boolean hasPin() {
        File f = new File("/data/data/ru.avdeev.android.mynotes/shared_prefs/" + PIN_CODE +".xml");
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public default boolean checkPin(String pinCode) {
        if (hasPin() && pinCode.equals(loadPinCode())) {
            return true;
        } else {
            return false;
        }
    }

    default void savePinCode(String text) {
        //mySharedPreferences.edit().putString(KEY,text).commit();
    }

    public default String loadPinCode() {
        return getSharedPreferences(PIN_CODE,MODE_PRIVATE).getString(KEY,"");
    }*/
}