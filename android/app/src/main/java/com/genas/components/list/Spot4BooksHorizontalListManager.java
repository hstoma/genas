package com.genas.components.list;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.genas.components.manager.ContextHolder;

import java.util.ArrayList;
import java.util.List;


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
        ContextHolder.getInstance().setContext(applicationReactNativeAppContext);
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

    @ReactProp(name = "bookList")
    public void setPositionAndRadius (Spot4BooksHorizontalListView view, ReadableArray bookList) {
        int size = bookList.size();
        List<SimpleItem> items = new ArrayList<>();
        for (int i=0;i<size;i++) {
            ReadableMap map = bookList.getMap(i);
            items.add(new SimpleItem(map.getString("title"),map.getString("url")));
        }
        if (items!=null) {
            listView.setAdapter(items);
        }
    }




}
