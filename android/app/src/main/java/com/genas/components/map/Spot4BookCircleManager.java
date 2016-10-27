package com.genas.components.map;

import android.graphics.Color;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by henadzistoma on 10/26/16.
 */

public class Spot4BookCircleManager extends ViewGroupManager<Spot4BookCircle> {

    private final ReactApplicationContext applicationReactNativeAppContext;

    private static final String NAME = "Spot4BooksCircle";

    public Spot4BookCircleManager(ReactApplicationContext applicationReactNativeAppContext) {
        this.applicationReactNativeAppContext = applicationReactNativeAppContext;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected Spot4BookCircle createViewInstance(ThemedReactContext reactContext) {
        return new Spot4BookCircle(reactContext);
    }

    @ReactProp(name = "positionAndRadius")
    public void setPositionAndRadius (Spot4BookCircle view, ReadableMap position) {
        view.setPositionAndRadius(position);
    }

    @ReactProp(name = "strokeColor", defaultInt = Color.GRAY, customType = "Color")
    public void setStrokeColor (Spot4BookCircle view, int color) {
        view.setStrokeColor(color);
    }

    @ReactProp(name = "fillColor", defaultInt = Color.GRAY, customType = "Color")
    public void setFillColor (Spot4BookCircle view, int color) {
        view.setFillColor(color);
    }
}
