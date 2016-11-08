package com.genas.components;

import android.content.Context;
import android.location.LocationManager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by henadzistoma on 10/31/16.
 */

public class SystemManager extends ReactContextBaseJavaModule {

    private static final String NAME = "SystemManager";
    ReactApplicationContext context;

    public SystemManager(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getLocationServicesState(Promise resolver) {
        String status  = "LOCATION_SERVICES_DISABLED";
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch(Exception ex) {}

        if(gps_enabled || network_enabled) {
            status = "LOCATION_SERVICES_ENABLED";
        }
        System.out.println("-2-----!!!!!!!!!!!!!!!-------------" + status);
        resolver.resolve(status);
    }
}
