package com.genas.components.map;

import android.content.Context;

import com.facebook.react.views.view.ReactViewGroup;

/**
 * Created by henadzistoma on 10/26/16.
 */

public abstract class Spot4BookMapFeature extends ReactViewGroup {
    private Object realObject;
    public Spot4BookMapFeature(Context context) {
        super(context);
    }
    public Object getRealObject() {
        return realObject;
    }

    public void setRealObject(Object realObject) {
        this.realObject = realObject;
    }


}
