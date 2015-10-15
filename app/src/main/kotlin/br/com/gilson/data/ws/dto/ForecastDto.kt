package br.com.gilson.data.ws.dto

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
data class ForecastDto {
    public var city: CityDto? = null
    public var list: List<ForecastDetailDto>? = null
}

class CityDto {
    public var name: String? = null
}

class ForecastDetailDto {
    public var dt: Long? = null
    public var main: TemperatureDto? = null
    public var weather: List<WeatherDto>? = null

}

class WeatherDto {
    public var main: String? = null
    public var description: String? = null
}

class TemperatureDto {
    public var temp: Float? = null
    public var temp_min: Float? = null
    public var temp_max: Float? = null
}
