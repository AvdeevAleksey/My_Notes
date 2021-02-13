package ru.avdeev.android.mynotes;

import android.content.SharedPreferences;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.prefs.Preferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;

public interface Keystore extends SharedPreferences {

    public final static String KEY = "key1";
    public final static String PIN_CODE = "pin_cod";
    public SharedPreferences mySharedPreferences = new SharedPreferences() {
        @Override
        public Map<String, ?> getAll() {
            return null;
        }

        @Nullable
        @Override
        public String getString(String s, @Nullable String s1) {
            return null;
        }

        @Nullable
        @Override
        public Set<String> getStringSet(String s, @Nullable Set<String> set) {
            return null;
        }

        @Override
        public int getInt(String s, int i) {
            return 0;
        }

        @Override
        public long getLong(String s, long l) {
            return 0;
        }

        @Override
        public float getFloat(String s, float v) {
            return 0;
        }

        @Override
        public boolean getBoolean(String s, boolean b) {
            return false;
        }

        @Override
        public boolean contains(String s) {
            return false;
        }

        @Override
        public Editor edit() {
            return null;
        }

        @Override
        public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

        }

        @Override
        public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

        }
    };

    default boolean hasPin() {
        File f = new File("/data/data/ru.avdeev.android.mynotes/shared_prefs/" + PIN_CODE +".xml");
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    };

    default boolean checkPin(String pinCode) {
        if (hasPin() && pinCode.equals(loadPinCode())) {
            return true;
        } else {
            return false;
        }
    };

    default void savePinCode(String pinCode) {
        mySharedPreferences.edit().putString(KEY,pinCode).commit();
    };

    default String loadPinCode() {
        return mySharedPreferences.getString(KEY,"");
    };


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