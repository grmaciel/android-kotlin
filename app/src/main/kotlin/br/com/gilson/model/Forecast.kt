package br.com.gilson.model

import java.util.*

/**
 * Created by Gilson Maciel on 03/10/2015.
 */

class Forecast(city: String, temperature: List<Weather>) {
    public val city: String = city
    public val temp: List<Weather> = temperature
}

class Weather(date: Date,  current: Float, min: Float, max: Float,description: String) {
    public val date: Date = date
    public val min: Float = min
    public val max: Float = min
    public val current: Float = min
    public val description: String = description
}
