package com.genas.components.map;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by henadzistoma on 10/26/16.
 */

public class Spot4BookMarkerManager extends ViewGroupManager<Spot4BookMarker> {

    private final ReactApplicationContext applicationReactNativeAppContext;

    private static final String NAME = "Spot4BooksMarker";

    public Spot4BookMarkerManager(ReactApplicationContext applicationReactNativeAppContext) {
        this.applicationReactNativeAppContext = applicationReactNativeAppContext;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected Spot4BookMarker createViewInstance(ThemedReactContext reactContext) {
        return new Spot4BookMarker(reactContext);
    }
    @ReactProp(name = "positionAndImageName")
    public void setPositionAndImageName (Spot4BookMarker view, ReadableMap positionAndImageName) {
        view.setPositionAndImageName(positionAndImageName);
    }
}
