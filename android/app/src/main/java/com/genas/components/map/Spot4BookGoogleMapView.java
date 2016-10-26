package com.genas.components.map;

import android.content.Context;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;

import static com.genas.components.map.Spot4BookMapConstants.LATITUDE;
import static com.genas.components.map.Spot4BookMapConstants.LONGTITUDE;
import static com.genas.components.map.Spot4BookMapConstants.ZOOM;

/**
 * Created by henadzistoma on 10/24/16.
 */

public class Spot4BookGoogleMapView extends MapView implements OnMapReadyCallback {

    private String mapStyle = new StringBuilder().append("[{\"featureType\":\"all\",\"elementType\": \"geometry\",\"stylers\":[{\"color\": \"#242f3e\"}]},")
            .append("{\"featureType\": \"all\",\"elementType\": \"labels.text.stroke\",\"stylers\":[{\"lightness\": -80}]},")
            .append("{\"featureType\": \"administrative\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#746855\"}]},")
            .append("{\"featureType\": \"administrative.locality\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#d59563\"}]},")
            .append("{\"featureType\": \"poi\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#d59563\"}]},")
            .append("{\"featureType\": \"poi.park\",\"elementType\": \"geometry\",\"stylers\": [{\"color\": \"#263c3f\"}]},")
            .append("{\"featureType\": \"poi.park\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#6b9a76\"}]},")
            .append("{\"featureType\": \"road\",\"elementType\": \"geometry.fill\",\"stylers\": [{\"color\": \"#2b3544\"}]},")
            .append("{\"featureType\": \"road\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#9ca5b3\"}]},")
            .append("{\"featureType\": \"road.arterial\",\"elementType\": \"geometry.fill\",\"stylers\": [{\"color\": \"#38414e\"}]},")
            .append("{\"featureType\": \"road.arterial\",\"elementType\": \"geometry.stroke\",\"stylers\": [{\"color\": \"#212a37\"}]},")
            .append("{\"featureType\": \"road.highway\",\"elementType\": \"geometry.fill\",\"stylers\": [{\"color\": \"#746855\"}]},")
            .append("{\"featureType\": \"road.highway\",\"elementType\": \"geometry.stroke\",\"stylers\": [{\"color\": \"#1f2835\"}]},")
            .append("{\"featureType\": \"road.highway\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#f3d19c\"}]},")
            .append("{\"featureType\": \"road.local\",\"elementType\": \"geometry.fill\",\"stylers\": [{\"color\": \"#38414e\"}]},")
            .append("{\"featureType\": \"road.local\",\"elementType\": \"geometry.stroke\",\"stylers\": [{\"color\": \"#212a37\"}]},")
            .append("{\"featureType\": \"transit\",\"elementType\": \"geometry\",\"stylers\": [{\"color\": \"#2f3948\"}]},")
            .append("{\"featureType\": \"transit.station\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#d59563\"}]},")
            .append("{\"featureType\": \"water\",\"elementType\": \"geometry\",\"stylers\": [{\"color\": \"#17263c\"}]},")
            .append("{\"featureType\": \"water\",\"elementType\": \"labels.text.fill\",\"stylers\": [{\"color\": \"#515c6d\"}]},")
            .append("{\"featureType\": \"water\",\"elementType\": \"labels.text.stroke\",\"stylers\": [{\"lightness\": -20}]}]").toString();

    public GoogleMap map;
    private ReadableMap centerAndZoom;

    public Spot4BookGoogleMapView(Context context) {

        super(context);
        super.onCreate(null);
        super.onResume();
        super.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setMapStyle(new MapStyleOptions(mapStyle));
        this.setCenterAndZoom(this.centerAndZoom);
    }


    public void clearMap() {
        if (map!=null) {
            map.clear();
        }
    }


    public void setCenterAndZoom(ReadableMap centerAndZoom) {
        if (centerAndZoom != null) {
            this.centerAndZoom = centerAndZoom;
            if (centerAndZoom.hasKey(LONGTITUDE) && centerAndZoom.hasKey(LATITUDE)) {
                Double lng = centerAndZoom.getDouble(LONGTITUDE);
                Double lat = centerAndZoom.getDouble(LATITUDE);
                int zoom = 10;
                if (centerAndZoom.hasKey(ZOOM)) {
                    zoom = centerAndZoom.getInt(ZOOM);
                }
                if (map!=null) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), zoom));
                }
            }
        }
    }



}
