package fyi.library.rxretrofit;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.internal.Primitives;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxRetrofit {

    private static final String TAG = RxRetrofit.class.getSimpleName();
    private RxRetrofitCallBack rxRetrofitCallBack;
    private Gson gson = new GsonBuilder().create();

    public RxRetrofit(Context context) {

        try {
            rxRetrofitCallBack = (RxRetrofitCallBack) context;
        } catch (Exception e) {
            Log.d(TAG, "RxRetrofit: callback methods are not implemented  " + e.getMessage());
        }
    }

    public <T> void getSimpleJsonQuery(@NonNull String baseUrl, String endPointString, Map<String,
            Object> urlParameters, Scheduler scheduleOn, final Class<T> returnClassType) {
        SOService service = RetrofitClient.getClient(baseUrl).create(SOService.class);

        Observer<Object> apiDetailObserver = new Observer<Object>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(@io.reactivex.annotations.NonNull Object object) {
                try {
                    JsonElement jsonElement = gson.toJsonTree(object);
                    rxRetrofitCallBack.getResult(gson.fromJson(jsonElement, returnClassType));

                } catch (Exception e) {
                    Log.d(TAG, "callback methods are not found " + e.getMessage());
                }

            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };

        Observable<Object> apiDetailObservable = service.getAnswersRxTest(endPointString, urlParameters);


        if (scheduleOn != null) {
            apiDetailObservable
                    .subscribeOn(scheduleOn)
                    .subscribe(apiDetailObserver);
        } else {
            apiDetailObservable
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(apiDetailObserver);
        }

    }

    public interface RxRetrofitCallBack {
        void getResult(Object result);
    }
}
