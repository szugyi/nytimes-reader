package io.szugyi.nytimes.data;

import io.reactivex.Observable;
import io.szugyi.nytimes.data.model.MostPopularApiResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NytimesApi {

    @GET("svc/mostpopular/v2/mostviewed/{section}/{time-period}.json")
    Observable<MostPopularApiResult> getArticles(@Path("section") String section,
                                                 @Path("time-period") Integer period,
                                                 @Query("api-key") String apiKey);
}
