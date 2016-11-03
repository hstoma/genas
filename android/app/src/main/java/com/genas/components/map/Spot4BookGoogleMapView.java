package com.genas.components.map;

import android.content.Context;
import android.view.View;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.genas.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static com.genas.components.map.Spot4BookMapConstants.LATITUDE;
import static com.genas.components.map.Spot4BookMapConstants.LONGTITUDE;
import static com.genas.components.map.Spot4BookMapConstants.ZOOM;

/**
 * Created by henadzistoma on 10/24/16.
 */

public class Spot4BookGoogleMapView extends MapView implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private String mapStyle;/* = new StringBuilder().append("[{\"featureType\":\"all\",\"elementType\": \"geometry\",\"stylers\":[{\"color\": \"#242f3e\"}]},")
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
            .append("{\"featureType\": \"water\",\"elementType\": \"labels.text.stroke\",\"stylers\": [{\"lightness\": -20}]}]").toString();*/

    public GoogleMap map;
    private ReadableMap centerAndZoom;
    private final List<Spot4BookMapFeature> features = new ArrayList<>();
    private Spot4BookMapViewManager manager;

    public Spot4BookGoogleMapView(Context context, Spot4BookMapViewManager manager) {

        super(context);
        super.onCreate(null);
        super.onResume();
        super.getMapAsync(this);
        this.manager = manager;


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (mapStyle!=null) {
            map.setMapStyle(new MapStyleOptions(mapStyle));
        }
        this.setCenterAndZoom(this.centerAndZoom);
        System.out.println("------------------------executed----------------");
        manager.pushEvent(this, Spot4BookMapViewManager.Events.EVENT_MAP_READY.toString(), null);
        if (this.features!=null) {
            for (Spot4BookMapFeature feature: features) {
                processFeature(feature);
            }
        }
        map.setOnMarkerClickListener(this);


    }


    public void clearMap() {
        if (map!=null) {
            map.clear();
        }
    }

    public void setCustomMapStyle(String mapStyle) {
        this.mapStyle = mapStyle;
        if (map!=null) {
            map.setMapStyle(new MapStyleOptions(mapStyle));
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

    public void addMapFeature(View item, int index) {
        System.out.println("=========!!!!!!!!!!!-----1");
        if (item instanceof  Spot4BookMapFeature) {
            features.add(index, (Spot4BookMapFeature) item);
            processFeature((Spot4BookMapFeature) item);
        }


    }

    public void processFeature(Spot4BookMapFeature item) {
        if (item instanceof  Spot4BookMarker) {
            Spot4BookMarker marker = (Spot4BookMarker)item;
            Marker mrk = this.addMarker(marker.getOptions());
            if (mrk!=null) {
                marker.setRealObject(mrk);
            }
        } else if (item instanceof Spot4BookCircle) {
            Spot4BookCircle circle = (Spot4BookCircle)item;
            Circle crk = addCircle(circle);
            if (crk!=null) {
                circle.setRealObject(crk);
            }

        }
    }

    public Circle addCircle(Spot4BookCircle circle) {
        Circle crk = null;
        if (circle != null) {
            if (map != null) {
                crk = map.addCircle(circle.getOptions());
            }
        }
        return crk;
    }

    public Marker addMarker(MarkerOptions options) {
        Marker mrk = null;
        if (options != null) {
                if (map != null) {
                    mrk = map.addMarker(options);
                }
        }
        return mrk;
    }

    public int getFeatureCount() {
        return features.size();
    }

    public View getFeatureAt(int index) {
        return features.get(index);
    }

    public void removeFeatureAt(int index) {
        Spot4BookMapFeature feature = features.remove(index);
        if (feature instanceof Spot4BookMarker) {
            if (feature.getRealObject()!=null) {
                ((Marker) feature.getRealObject()).remove();
            }
        } else if (feature instanceof Spot4BookCircle) {
            if (feature.getRealObject()!=null) {
                ((Circle) feature.getRealObject()).remove();
            }
        }
    }

    public String getFeatureIndentifier(Object featureRealObject) {
        String indentifier = null;
        if (features!=null) {
            for (Spot4BookMapFeature feature: features) {
                if (featureRealObject.equals(feature.getRealObject())) {
                    indentifier = feature.getIdentifier();
                }
            }
        }
        return indentifier;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        String indentifier = getFeatureIndentifier(marker);
        WritableMap map = new WritableNativeMap();
        if (indentifier!=null) {
            map.putString("markerId",indentifier);
        }
        manager.pushEvent(this, Spot4BookMapViewManager.Events.EVENT_MARKER_TOUCHED.toString(), map);
        return true;
    }
}
