package com.genas.components.map;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.MapsInitializer;

/**
 * Created by henadzistoma on 10/24/16.
 */

public class Spot4BookMapViewManager extends ViewGroupManager<Spot4BookGoogleMapView> {

    private static final String NAME = "Spot4BooksMap";

    private ReactContext reactNativeContext;

    private final ReactApplicationContext applicationReactNativeAppContext;

    public Spot4BookMapViewManager(ReactApplicationContext applicationReactNativeappContext) {
        this.applicationReactNativeAppContext = applicationReactNativeappContext;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected Spot4BookGoogleMapView createViewInstance(ThemedReactContext reactContext) {
        reactNativeContext = reactContext;
        System.out.println("==============111");
        try {
            MapsInitializer.initialize(this.applicationReactNativeAppContext);
        } catch (RuntimeException e) {
            e.printStackTrace();

        }

        return new Spot4BookGoogleMapView(reactNativeContext);
    }


    @ReactMethod
    public void clear(Spot4BookGoogleMapView view) {
        view.clearMap();
    }

    @ReactProp(name = "centerAndZoom")
    public void setCenterAndZoom(Spot4BookGoogleMapView view, ReadableMap centerAndZoom) {
        view.setCenterAndZoom(centerAndZoom);
    }
}
