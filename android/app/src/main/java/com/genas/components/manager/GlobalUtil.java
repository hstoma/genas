package com.genas.components.manager;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;


/**
 * The Class GlobalUtil.
 * 
 * @author GenaS
 */
public class GlobalUtil {

	public static int convertDpiToPixels(Context context, int value) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (value * scale + 0.5f);
	}
}
