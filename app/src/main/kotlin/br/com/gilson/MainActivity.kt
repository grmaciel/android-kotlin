package br.com.gilson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.gilson.adapter.ForecastAdapter
import br.com.gilson.model.Forecast
import butterknife.bindView


class MainActivity : AppCompatActivity() {
    val forecast: RecyclerView by bindView(R.id.forecasts);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        forecast.adapter = ForecastAdapter(getFakeForest());
        forecast.layoutManager = LinearLayoutManager(this)
    }

    private fun getFakeForest(): List<Forecast> {
        var cast1 = Forecast()
        var cast2 = Forecast()

        val foreCasts: List<Forecast> = listOf()
        foreCasts.plus(cast1)
        foreCasts.plus(cast2)

        return foreCasts;
    }

}
