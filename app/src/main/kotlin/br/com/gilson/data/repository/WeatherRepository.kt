package br.com.gilson.data.repository

import br.com.gilson.data.ws.WeatherService
import br.com.gilson.data.ws.dto.ForecastDto
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
class WeatherRepository(val weatherService: WeatherService) {

    public fun getForecast(dayCount: Int, city: String): Observable<ForecastDto> {
        return weatherService.weatherForecast(dayCount, city)
                .subscribeOn(Schedulers.newThread())
                .flatMap { Observable.from(it) }
    }
}