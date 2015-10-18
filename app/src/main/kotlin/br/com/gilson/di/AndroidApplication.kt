package br.com.gilson.di

import android.app.Application
import br.com.gilson.di.component.ApplicationComponent
import br.com.gilson.di.component.DaggerApplicationComponent
import br.com.gilson.di.component.DaggerRestComponent
import br.com.gilson.di.module.ApplicationModule
import br.com.gilson.di.module.RestModule

/**
 * Created by Gilson Maciel on 18/10/2015.
 */
public class AndroidApplication : Application() {
    private var component: ApplicationComponent = initComponent();

    override fun onCreate() {
        super.onCreate()
        initComponent()

    }

    private fun initComponent(): ApplicationComponent {
        val rest = DaggerRestComponent.builder()
                .restModule(RestModule())
                .build()

        return DaggerApplicationComponent.builder()
                .restComponent(rest)
                .applicationModule(ApplicationModule(this))
                .build()
    }

    public fun getApplicationComponent(): ApplicationComponent {
        return component
    }
}