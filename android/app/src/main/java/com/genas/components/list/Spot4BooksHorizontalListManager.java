package com.genas.components.list;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;


/**
 * Created by henadzistoma on 11/3/16.
 */

public class Spot4BooksHorizontalListManager extends ViewGroupManager<Spot4BooksHorizontalListView> {

    public static final String NAME = "Spot4BooksHorizontalListView";

    private ReactContext reactNativeContext;

    private final ReactApplicationContext applicationReactNativeAppContext;

    private Spot4BooksHorizontalListView listView;

    public Spot4BooksHorizontalListManager(ReactApplicationContext applicationReactNativeAppContext) {
        this.applicationReactNativeAppContext = applicationReactNativeAppContext;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected Spot4BooksHorizontalListView createViewInstance(ThemedReactContext reactContext) {
        this.reactNativeContext = reactContext;
        listView = new Spot4BooksHorizontalListView(reactContext);
        return listView;
    }



}
