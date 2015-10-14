package br.com.gilson.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.gilson.R
import br.com.gilson.data.ws.WeatherRest
import br.com.gilson.data.ws.dto.ForecastDto
import br.com.gilson.view.adapter.ForecastAdapter
import br.com.gilson.model.Forecast
import butterknife.bindView
import retrofit.Retrofit
import rx.android.schedulers.AndroidSchedulers


class MainActivity : AppCompatActivity() {
    val forecast: RecyclerView by bindView(R.id.forecasts);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        queryWSData();

    }

    private fun queryWSData() {
        createRestService()
                .weatherForecast(1, "Blumenau")
                .observeOn(AndroidSchedulers.mainThread())
                .map { data -> mapDtoToModel(data) }
                .subscribe { data -> renderAdapterData(data) }
    }

    private fun mapDtoToModel(data: List<ForecastDto>): List<Forecast> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun renderAdapterData(adapterData: List<Forecast>) {
        forecast.adapter = ForecastAdapter(adapterData);
        forecast.layoutManager = LinearLayoutManager(this)
    }

    private fun createRestService(): WeatherRest {
        return Retrofit.Builder()
                .baseUrl("aa")
                .build()
                .create(WeatherRest::class.java)
    }

}
