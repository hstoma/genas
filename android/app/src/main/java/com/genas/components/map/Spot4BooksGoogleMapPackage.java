package com.genas.components.map;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by henadzistoma on 10/24/16.
 */

public class Spot4BooksGoogleMapPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        Spot4BookMapViewManager mapManager = new Spot4BookMapViewManager(reactContext);
        Spot4BookMarkerManager markerManager = new Spot4BookMarkerManager(reactContext);
        return Arrays.<ViewManager>asList(mapManager, markerManager);
    }
}
