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

class ForecastDetailDto(dt: Long, temp: TemperatureDto, weather: List<WeatherDto>) {
    public var dt: Long = dt
    public var temp: TemperatureDto = temp
    public var weather: List<WeatherDto> = weather

}

class WeatherDto(main: String, descripton: String) {
    public var main: String = main
    public var description: String = descripton
}

class TemperatureDto(day: Float, min: Float, max: Float) {
    public var day: Float = day
    public var min: Float = min
    public var max: Float = max
}
