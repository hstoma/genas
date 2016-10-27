package com.genas.components.map;

import android.view.View;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.MapsInitializer;

import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by henadzistoma on 10/24/16.
 */

public class Spot4BookMapViewManager extends ViewGroupManager<Spot4BookGoogleMapView> {

    private static final String NAME = "Spot4BooksMap";

    private ReactContext reactNativeContext;

    private final ReactApplicationContext applicationReactNativeAppContext;

    private Spot4BookGoogleMapView mapView;

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
        try {
            MapsInitializer.initialize(this.applicationReactNativeAppContext);
        } catch (RuntimeException e) {
            e.printStackTrace();

        }
        mapView = new Spot4BookGoogleMapView(reactNativeContext, this);
        return mapView;
    }


    @Override
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> map = MapBuilder.of("onMapReady", MapBuilder.of("registrationName", "onMapReady"));
        return map;
    }

    @ReactProp(name = "centerAndZoom")
    public void setCenterAndZoom(Spot4BookGoogleMapView view, ReadableMap centerAndZoom) {
        view.setCenterAndZoom(centerAndZoom);
    }




    @Override
    public void addView(Spot4BookGoogleMapView mapView, View child, int index) {
        System.out.println("-----------Add view" + index);
        mapView.addMapFeature(child, index);
    }

    @Override
    public int getChildCount(Spot4BookGoogleMapView view) {
        return view.getFeatureCount();
    }

    public View getChildAt(Spot4BookGoogleMapView mapView, int index) {
        return mapView.getFeatureAt(index);
    }

    @Override
    public void removeViewAt(Spot4BookGoogleMapView mapView, int index) {
        mapView.removeFeatureAt(index);
    }

    void pushEvent(View view, String name, WritableMap data) {
        reactNativeContext.getJSModule(RCTEventEmitter.class).receiveEvent(view.getId(), name, data);
    }


}
