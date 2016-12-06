// package com.askruru;

// import android.app.Activity;
// import android.content.Intent;
// import android.database.Cursor;
// import android.net.Uri;
// import android.provider.ContactsContract;
// import android.util.Log;

// import com.facebook.react.bridge.ActivityEventListener;
// import com.facebook.react.bridge.Arguments;
// import com.facebook.react.bridge.BaseActivityEventListener;
// import com.facebook.react.bridge.Callback;
// import com.facebook.react.bridge.ReactApplicationContext;
// import com.facebook.react.bridge.ReactContextBaseJavaModule;
// import com.facebook.react.bridge.ReactMethod;
// import com.facebook.react.bridge.WritableArray;
// import com.facebook.react.bridge.WritableMap;

// import org.json.JSONException;
// import org.json.JSONObject;

// public class PickContactModule extends ReactContextBaseJavaModule {


//     public PickContactModule(ReactApplicationContext reactContext) {
//       super(reactContext);

//       // Add the listener for `onActivityResult
//       reactContext.addActivityEventListener(mActivityEventListener);
//     }

//     @Override
//     public String getName() { 

//         return "PickContact";

//     }

//     private static final int CONTACT_PICKER_RESULT = 1000;
//     private Callback mSuccess;
//     private Callback merror;

//     private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

//         //Based on https://github.com/apache/cordova-plugin-contacts
//         @Override
//         public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
//             if (requestCode == CONTACT_PICKER_RESULT) {
//                 if (resultCode == Activity.RESULT_OK) {
//                     String contactId = intent.getData().getLastPathSegment();

//                     Cursor c =  activity.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI,
//                             new String[] {ContactsContract.RawContacts._ID}, ContactsContract.RawContacts.CONTACT_ID + " = " + contactId, null, null);
//                     if (!c.moveToFirst()) {
//                         //Error occured while retrieving contact raw id
//                         return;
//                     }
//                     String id = c.getString(c.getColumnIndex(ContactsContract.RawContacts._ID));
//                     c.close();

//                     try {
//                         JSONObject contact = contactAccessor.getContactById(id);
//                         this.callbackContext.success(contact);
//                         return;
//                     } catch (JSONException e) {
//                         //JSON fail
//                     }
//                 } else if (resultCode == Activity.RESULT_CANCELED) {
//                     //activity canceled
//                     return;
//                 }

//                 //Return error. Unknown
//             }
//         }
//     };

//     @ReactMethod
//     public void pickContact(Callback error, Callback success) {

//         mSuccess = success;
//         merror = error;

//         success.invoke();
//     }
    
// }
