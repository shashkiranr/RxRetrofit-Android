package fyi.rxretrofittest;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

    private static final String TAG = "DateTimeUtils";

    public static long getCurrentTimeinSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static Address getLatLng(String location, Context mContext) {
        Address address = null;
        try {
            Geocoder gc = new Geocoder(mContext);
            List<Address> addresses = gc.getFromLocationName(location, 1); // get the found Address Objects

            for (Address a : addresses) {
                if (a.hasLatitude() && a.hasLongitude()) {
//                    Log.i(TAG, String.valueOf(location + "   " + a.getLatitude() + "
// " + a.getLongitude()));
                    address = a;
                } else {
                    Log.d(TAG, " this location has no entry " + location);
                }
            }
        } catch (IOException e) {
            // handle the exception
        }

        return address;
    }


}
