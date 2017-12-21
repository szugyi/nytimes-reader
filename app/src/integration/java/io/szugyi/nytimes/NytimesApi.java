package io.szugyi.nytimes;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NytimesApi {

    @GET("search")
    Observable<ResponseBody> search(@Query("q") String query);
}
