package br.com.gilson.data.repository

import br.com.gilson.data.ws.WeatherRest
import br.com.gilson.data.ws.dto.ForecastDto
import br.com.gilson.model.Forecast
import br.com.gilson.model.Temperature
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
class WeatherRepository(val weatherService: WeatherRest) {
    public fun getForecast(city: String): Observable<List<Forecast>> {
        return weatherService.weatherForecast(city)
                .flatMap(mapDtoToModel())
                .subscribeOn(Schedulers.newThread())
    }

    private fun mapDtoToModel() = { dto: ForecastDto ->
        val name = dto.city.name
        Observable.just(
                dto.list.map { detail ->
                    val main = detail.main
                    val temp: Temperature = Temperature(main.temp, main.temp_max, main.temp_min)
                    Forecast(name, temp)
                })
    }
}