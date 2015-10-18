package br.com.gilson.model

/**
 * Created by Gilson Maciel on 03/10/2015.
 */

class Forecast(city: String, temperature : Temperature) {
    public val city: String = city
    public val temp: Temperature = temperature
}

class Temperature(min : Float, max : Float, current : Float) {
    public val min : Float = min
    public val max : Float = min
    public val current : Float = min
}
