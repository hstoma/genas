package com.genas.components.simple;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by henadzistoma on 10/25/16.
 */

public class SimpleLabelViewManager extends ViewGroupManager<SimpleLabelView> {

    private final static String NAME = "SimpleLabelView";

    private final ReactApplicationContext applicationReactNativeAppContext;
    private ReactContext reactNativeContext;

    public SimpleLabelViewManager(ReactApplicationContext applicationReactNativeAppContext) {
        this.applicationReactNativeAppContext = applicationReactNativeAppContext;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected SimpleLabelView createViewInstance(ThemedReactContext reactContext) {
        return new SimpleLabelView(reactContext);
    }

    @ReactProp(name = "labelText")
    public void setLabelText(SimpleLabelView view, String labelText) {
        view.setLabelText(labelText);
    }
}
