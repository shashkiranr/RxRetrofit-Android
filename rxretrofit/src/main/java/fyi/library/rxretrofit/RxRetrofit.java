package fyi.library.rxretrofit;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxRetrofit {

    private static final String TAG = RxRetrofit.class.getSimpleName();
    private RxRetrofitCallBack rxRetrofitCallBack;


    public RxRetrofit(Context context) {

        try {
            rxRetrofitCallBack = (RxRetrofitCallBack) context;
        } catch (Exception e) {
            Log.d(TAG, "RxRetrofit: callback methods are not implemented  " + e.getMessage());
        }
    }

    public void getSimpleJsonQuery(@NonNull String baseUrl, String endPointString, Map<String, Object> urlParameters, Scheduler scheduleOn) {
        SOService service = RetrofitClient.getClient(baseUrl).create(SOService.class);

        Observer<Object> apiDetailObserver = new Observer<Object>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull Object object) {
                try {
                    rxRetrofitCallBack.getResult(object);
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
