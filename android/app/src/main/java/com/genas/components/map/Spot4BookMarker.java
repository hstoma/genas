package com.genas.components.map;

import android.content.Context;

import com.facebook.react.bridge.ReadableMap;
import com.genas.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.genas.components.map.Spot4BookMapConstants.LATITUDE;
import static com.genas.components.map.Spot4BookMapConstants.LONGTITUDE;
import static com.genas.components.map.Spot4BookMapConstants.MARKER_IMAGE;

/**
 * Created by henadzistoma on 10/26/16.
 */

public class Spot4BookMarker extends Spot4BookMapFeature {

    private final Context context;
    private MarkerOptions options;

    public Spot4BookMarker(Context context) {
        super(context);
        this.context = context;
    }

    public void setPositionAndImageName(ReadableMap markerInfo) {
        if (markerInfo != null) {
            if (markerInfo.hasKey(LONGTITUDE) && markerInfo.hasKey(LATITUDE) && markerInfo.hasKey(MARKER_IMAGE)) {
                Double lng = markerInfo.getDouble(LONGTITUDE);
                Double lat = markerInfo.getDouble(LATITUDE);
                String markerImage = markerInfo.getString(MARKER_IMAGE);
                options = new MarkerOptions();
                options.position(new LatLng(lat, lng));
                options.icon(BitmapDescriptorFactory.fromResource(Spot4BookMapUtils.getDrawableResourceId(context, markerImage)));
            }
        }
    }

    public MarkerOptions getOptions() {
        return this.options;
    }
}
