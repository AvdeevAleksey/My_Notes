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
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences((Context) this);
        if (preferences.contains(KEY)) {
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
        if (pinCode.length()!=0 && !pinCode.isEmpty() && !pinCode.equals(loadPinCode())) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences((Context) this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(KEY, pinCode).commit();
            Toster.showMyMessage(R.string.new_pin_saved, (Context) this);
        } else {
            Toster.showMyMessage(R.string.old_pin_saved, (Context) this);
        }
    }

    default String loadPinCode() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences((Context) this);
        return preferences.getString(KEY,"");
    }
}