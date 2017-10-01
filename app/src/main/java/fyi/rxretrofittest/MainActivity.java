package fyi.rxretrofittest;

import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;


import fyi.library.rxretrofit.RxRetrofit;
import fyi.rxretrofittest.model.ApiDetail;


public class MainActivity extends AppCompatActivity implements RxRetrofit.RxRetrofitCallBack {

    private static final String API_KEY = "";
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/timezone/";
    public static final String END_POINT_STRING = "json?";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String addressFormat = null;
        Address address = DateTimeUtils.getLatLng("seol", this);
        if (address != null) {
            addressFormat = address.getLatitude() + "," + address.getLongitude();
        } else {
            Log.d(TAG, "onCreate:  address not available");
        }


        Map<String, Object> data = new HashMap<>();
        data.put("location", addressFormat);
        data.put("timestamp", DateTimeUtils.getCurrentTimeinSeconds());
        data.put("key", API_KEY);

        RxRetrofit rxRetrofit = new RxRetrofit(this);
        rxRetrofit.getSimpleJsonQuery(BASE_URL,END_POINT_STRING, data, null,ApiDetail.class);
    }


    @Override
    public void onNext(Object result) {
        ApiDetail apiDetail = (ApiDetail) result;
        Log.d(TAG, "apidetail to string " + result.toString());
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: " + e.toString());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");

    }
}
