package com.genas.components.list;

import android.view.View;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.genas.components.manager.ContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;


/**
 * Created by henadzistoma on 11/3/16.
 */

public class Spot4BooksHorizontalListManager extends ViewGroupManager<Spot4BooksHorizontalListView> implements Spot4BooksHorizontalViewItemListener{

    public static final String NAME = "Spot4BooksHorizontalListView";

    public static final String REGISTRATION_NAME = "registrationName";

    private ReactContext reactNativeContext;

    private final ReactApplicationContext applicationReactNativeAppContext;

    private Spot4BooksHorizontalListView listView;

    public enum Events {
        EVENT_ITEM_TOUCHED("onItemTouched");


        private final String mName;

        Events(final String name) {
            mName = name;
        }

        @Override
        public String toString() {
            return mName;
        }
    }

    @Override
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
        for (Events event : Events.values()) {
            builder.put(event.toString(), MapBuilder.of(REGISTRATION_NAME, event.toString()));
        }
        return builder.build();
    }


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
        listView = new Spot4BooksHorizontalListView(reactContext, this);
        return listView;
    }

    @ReactProp(name = "bookList")
    public void setBookList (Spot4BooksHorizontalListView view, ReadableArray bookList) {
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


    void pushEvent(View view, String name, WritableMap data) {
        reactNativeContext.getJSModule(RCTEventEmitter.class).receiveEvent(view.getId(), name, data);
    }

    @Override
    public void onItemClick(String itemId) {
        WritableMap map = new WritableNativeMap();
        if (itemId!=null) {
            map.putString("itemId",itemId);
        }
        this.pushEvent(listView, Events.EVENT_ITEM_TOUCHED.toString(), map);
    }
}
