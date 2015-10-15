package br.com.gilson.data.repository

import br.com.gilson.data.ws.WeatherRest
import br.com.gilson.data.ws.dto.ForecastDto
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
class WeatherRepository(val weatherService: WeatherRest) {
    public fun getForecast(city: String): Observable<ForecastDto> {
        return weatherService.weatherForecast(city)
                .subscribeOn(Schedulers.newThread())
    }
}