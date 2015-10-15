package br.com.gilson.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import br.com.gilson.R
import br.com.gilson.data.ws.WeatherRest
import br.com.gilson.data.ws.dto.ForecastDto
import br.com.gilson.model.Forecast
import br.com.gilson.view.adapter.ForecastAdapter
import butterknife.bindView
import com.squareup.okhttp.OkHttpClient
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    val forecast: RecyclerView by bindView(R.id.forecasts);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        queryWSData();

    }

    private fun queryWSData() {
        createRestService()
                .weatherForecast("Blumenau")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map { data -> mapDtoToModel(data) }
                .subscribe ({ data -> renderAdapterData(data) },
                        { error -> Log.e("Error", error.toString()) })
    }

    private fun mapDtoToModel(data: ForecastDto): List<Forecast> {
        return listOf();
    }

    private fun renderAdapterData(adapterData: List<Forecast>) {
        forecast.adapter = ForecastAdapter(adapterData);
        forecast.layoutManager = LinearLayoutManager(this)
    }

    private fun createRestService(): WeatherRest =
            Retrofit.Builder()
                    .client(OkHttpClient())
                    .baseUrl("http://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
                    .create(WeatherRest::class.java);
}