package br.com.gilson.data.repository

import br.com.gilson.data.ws.WeatherRest
import br.com.gilson.data.ws.dto.ForecastDto
import br.com.gilson.model.Forecast
import br.com.gilson.model.Weather
import rx.Observable
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
class WeatherRepository(val weatherService: WeatherRest) {
    public fun getForecast(city: String): Observable<Forecast> {
        return weatherService.weatherForecast(city)
                .map(mapDtoToModel())
                .subscribeOn(Schedulers.newThread())
    }

    private fun mapDtoToModel() = { dto: ForecastDto ->
        Forecast(dto.city.name, extractWeatherFromDto(dto))
    }

    private fun extractWeatherFromDto(dto: ForecastDto): List<Weather> {
        return dto.list.map { detail ->
            val temp = detail.temp
            Weather(Date(detail.dt*1000), temp.day,
                    temp.min,
                    temp.max,
                    detail.weather.get(0).description)
        }
    }
}