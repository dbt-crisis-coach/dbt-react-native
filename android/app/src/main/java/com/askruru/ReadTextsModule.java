package com.askruru;

import android.database.Cursor;
import android.net.Uri;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext; 
import com.facebook.react.bridge.ReactContext; 
import com.facebook.react.bridge.ReactContextBaseJavaModule; 
import com.facebook.react.bridge.ReactMethod;

public class ReadTextsModule extends ReactContextBaseJavaModule { 
  
  
    public ReadTextsModule(ReactApplicationContext reactContext) { 
      super(reactContext);
    }

    @Override
    public String getName() { 

        return "ReadTexts";

    }

    @ReactMethod
    public void getTextMessages(Callback error, Callback success) {
        Cursor cursor = getReactApplicationContext().getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        String msgData = "";
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {

                for(int idx=0;idx<cursor.getColumnCount();idx++)
                {
                    msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
                }
                // use msgData
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }


        success.invoke(msgData);
    }
    
}
