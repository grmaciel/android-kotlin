package br.com.gilson.view.activity

import android.support.v7.app.AppCompatActivity
import br.com.gilson.di.AndroidApplication
import br.com.gilson.di.component.ApplicationComponent

/**
 * Created by Gilson Maciel on 18/10/2015.
 */
public abstract class BaseActivity : AppCompatActivity() {
    public fun applicationComponent(): ApplicationComponent {
        return (application as AndroidApplication)
                .getApplicationComponent()
    }
}
