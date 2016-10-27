package com.genas.components.map;

import android.content.Context;
import android.content.res.Resources;

import com.genas.R;

/**
 * Created by henadzistoma on 10/26/16.
 */

public class Spot4BookMapUtils {

    private static final String DRAWABLE = "drawable";
    private static final String STRING = "string";
    private static final String RAW = "raw";
    private static final String PNG_LOW = ".png";
    private static final String PNG_UP = ".PNG";
    private static final String JPG_LOW = ".jpg";
    private static final String JPG_UP = ".JPG";
    private static final String EMPTY_STRING = "";

    public static int getDrawableResourceId(Context context, final String name) {
        int retValue;
        if (name!=null) {
            String trimmedName = name.replace(PNG_LOW, EMPTY_STRING).replace(PNG_UP, EMPTY_STRING).replace(JPG_LOW, EMPTY_STRING).replace(JPG_UP, EMPTY_STRING).trim();
            Resources resources = context.getResources();
            retValue = resources.getIdentifier(trimmedName, DRAWABLE, context.getPackageName());
            if (retValue == 0) {
                retValue = R.drawable.icon;
            }
        } else {
            retValue = R.drawable.icon;
        }
        return retValue;
    }
}
