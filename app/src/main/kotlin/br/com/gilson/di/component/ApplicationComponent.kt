package br.com.gilson.di.component

import android.content.Context
import br.com.gilson.data.repository.WeatherRepository
import br.com.gilson.di.module.ApplicationModule
import br.com.gilson.view.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Gilson Maciel on 18/10/2015.
 */
@Singleton
@Component(dependencies = arrayOf(RestComponent::class),
        modules = arrayOf(ApplicationModule::class))
public interface ApplicationComponent {
    public fun context(): Context

    public fun weatherRepository(): WeatherRepository

    public fun inject(activity: MainActivity)
}