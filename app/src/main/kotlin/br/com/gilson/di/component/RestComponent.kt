package br.com.gilson.di.component

import br.com.gilson.data.ws.WeatherRest
import br.com.gilson.di.module.RestModule
import dagger.Component

/**
 * Created by Gilson Maciel on 18/10/2015.
 */
@Component(modules = arrayOf(RestModule::class))
public interface RestComponent {
    public fun weatherRest(): WeatherRest

}
