package br.com.gilson.view.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import br.com.gilson.R
import br.com.gilson.data.repository.WeatherRepository
import br.com.gilson.model.Forecast
import br.com.gilson.view.adapter.ForecastAdapter
import butterknife.bindView
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class MainActivity : BaseActivity() {
    val forecast: RecyclerView by bindView(R.id.forecasts);
    @Inject
    lateinit var weatherRepository: WeatherRepository;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectData()
        queryWSData();

    }

    private fun injectData() {
        applicationComponent()
                .inject(this)
    }

    private fun queryWSData() {
        weatherRepository.getForecast("Blumenau")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { data -> renderAdapterData(data) },
                        { error -> Log.e("Error", error.toString()) })
    }

    private fun renderAdapterData(adapterData: List<Forecast>) {
        forecast.adapter = ForecastAdapter(adapterData);
        forecast.layoutManager = LinearLayoutManager(this)
    }
}