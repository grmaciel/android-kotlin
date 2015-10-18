package br.com.gilson.di.module

import br.com.gilson.data.ws.WeatherRest
import com.squareup.okhttp.OkHttpClient
import dagger.Module
import dagger.Provides
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

/**
 * Created by Gilson Maciel on 18/10/2015.
 */
@Module
public class RestModule() {
    @Provides
    public fun weatherRest(): WeatherRest {
        return Retrofit.Builder()
                .client(OkHttpClient())
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(WeatherRest::class.java);
    }

}
