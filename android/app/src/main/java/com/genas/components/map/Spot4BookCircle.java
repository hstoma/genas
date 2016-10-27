package com.genas.components.map;

import android.content.Context;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.genas.components.map.Spot4BookMapConstants.LATITUDE;
import static com.genas.components.map.Spot4BookMapConstants.LONGTITUDE;
import static com.genas.components.map.Spot4BookMapConstants.MARKER_IMAGE;
import static com.genas.components.map.Spot4BookMapConstants.RADIUS;

/**
 * Created by henadzistoma on 10/26/16.
 */

public class Spot4BookCircle extends Spot4BookMapFeature {


    private static final float strokeWidth = 1.0f;
    private CircleOptions options;
    private final Context context;
    private int strokeColor;
    private Double lng;
    private Double lat;
    private Double radius;
    private int fillColor;

    public Spot4BookCircle(Context context) {
        super(context);
        this.context = context;
        options = new CircleOptions();
        options.strokeWidth(strokeWidth);
        options.clickable(false);
    }

    public void setPositionAndRadius(ReadableMap circleInfo) {
        if (circleInfo != null) {
            if (circleInfo.hasKey(LONGTITUDE) && circleInfo.hasKey(LATITUDE) && circleInfo.hasKey(RADIUS)) {
                lng = circleInfo.getDouble(LONGTITUDE);
                lat = circleInfo.getDouble(LATITUDE);
                options.center(new LatLng(lat, lng));
                radius = circleInfo.getDouble(RADIUS);
                options.radius(radius);
            }
        }
    }

    public void setStrokeColor(int color) {
        this.strokeColor = color;
        options.strokeColor(this.strokeColor);
    }

    public void setFillColor(int color) {
        this.fillColor = color;
        options.fillColor(this.fillColor);
    }

    public CircleOptions getOptions() {
        return options;
    }
}
