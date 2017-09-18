package fyi.library.rxretrofit;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface SOService {

    @GET()
    Observable<Object> getAnswersRxTest(@Url String endPath, @QueryMap Map<String, Object> options);
}