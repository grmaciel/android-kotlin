package br.com.gilson.data.ws.dto

/**
 * Created by Gilson Maciel on 06/10/2015.
 */
data class ForecastDto(city: CityDto, list: List<ForecastDetailDto>) {
    public var city: CityDto = city
    public var list: List<ForecastDetailDto> = list
}

class CityDto(name: String) {
    public var name: String = name;
}

class ForecastDetailDto(dt: Long, main: TemperatureDto, weather: List<WeatherDto>) {
    public var dt: Long = dt
    public var main: TemperatureDto = main
    public var weather: List<WeatherDto> = weather

}

class WeatherDto(main: String, descripton: String) {
    public var main: String = main
    public var description: String = descripton
}

class TemperatureDto(temp: Float, temp_min: Float, temp_max: Float) {
    public var temp: Float = temp
    public var temp_min: Float = temp_min
    public var temp_max: Float = temp_max
}
