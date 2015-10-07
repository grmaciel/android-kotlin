package br.com.gilson.data.ws

import br.com.gilson.data.ws.dto.ForecastDto
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
public interface RestApi {
    @GET("/data/2.5/forecast/daily?units=metric")
    fun weatherForecast(@Query("cnt") dayCount: Int,
                        @Query("q") city: String): Observable<List<ForecastDto>>

}