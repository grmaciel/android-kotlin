package br.com.gilson.data.ws

import br.com.gilson.data.ws.dto.ForecastDto
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
interface WeatherRest {
    @GET("/data/2.5/forecast/weather?units=metric&APPID=e4ca48547a2201a6d6242a62431f1e6c&cnt=5")
    fun weatherForecast(@Query("q") city: String): Observable<ForecastDto>
}