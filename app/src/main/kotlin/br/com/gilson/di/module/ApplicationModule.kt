package br.com.gilson.di.module

import android.content.Context
import br.com.gilson.data.repository.WeatherRepository
import br.com.gilson.data.ws.WeatherRest
import br.com.gilson.di.AndroidApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Gilson Maciel on 18/10/2015.
 */
@Module
public class ApplicationModule(app: AndroidApplication) {
    val app = app;

    @Provides
    @Singleton
    public fun context(): Context {
        return app;
    }

    @Provides
    @Singleton
    public fun weatherRepository(weatherRest: WeatherRest): WeatherRepository {
        return WeatherRepository(weatherRest)
    }

}