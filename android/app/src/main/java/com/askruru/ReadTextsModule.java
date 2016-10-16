package com.askruru;

import android.database.Cursor;
import android.net.Uri;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext; 
import com.facebook.react.bridge.ReactContext; 
import com.facebook.react.bridge.ReactContextBaseJavaModule; 
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

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

        WritableArray allSMS = Arguments.createArray();
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                WritableMap data = Arguments.createMap();
                for(int idx=0;idx<cursor.getColumnCount();idx++)
                {

                    switch(cursor.getType(idx)) {
                        case Cursor.FIELD_TYPE_NULL:
                            data.putNull(cursor.getColumnName(idx));
                            break;
                        case Cursor.FIELD_TYPE_INTEGER:
                        case Cursor.FIELD_TYPE_FLOAT:
                            data.putInt(cursor.getColumnName(idx), cursor.getInt(idx));
                            break;
                        case Cursor.FIELD_TYPE_STRING:
                            data.putString(cursor.getColumnName(idx), cursor.getString(idx));
                            break;
                        default:
                            data.putString(cursor.getColumnName(idx), cursor.getString(idx));
                            break;
                    }
                }
                allSMS.pushMap(data);
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }


        success.invoke(allSMS);
    }
    
}
