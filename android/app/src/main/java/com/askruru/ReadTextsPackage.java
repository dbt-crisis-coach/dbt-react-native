package com.askruru;

import com.facebook.react.bridge.NativeModule; 
import com.facebook.react.bridge.ReactApplicationContext; 
import com.facebook.react.bridge.ReactContext; 
import com.facebook.react.bridge.ReactContextBaseJavaModule; 
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.ReactPackage;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;
import java.util.*;


public class ReadTextsPackage implements ReactPackage { 
  @Override 
  public List<Class<? extends JavaScriptModule>> createJSModules() { 
    return Collections.emptyList(); 
  } 
  
  @Override public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) { 
    return Collections.emptyList(); 
  } 
  
  @Override public List<NativeModule> createNativeModules( ReactApplicationContext reactContext) { 
    List<NativeModule> modules = new ArrayList<>(); 
    modules.add(new ReadTextsModule(reactContext)); 
    
    return modules; 
  }
}