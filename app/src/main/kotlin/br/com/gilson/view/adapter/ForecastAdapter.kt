package br.com.gilson.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import br.com.gilson.R
import br.com.gilson.model.Forecast
import br.com.gilson.model.Weather
import br.com.gilson.util.DateUtil
import butterknife.bindView

/**
 * Created by Gilson Maciel on 03/10/2015.
 */
class ForecastAdapter(data: List<Forecast>) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    val data = data

    override fun getItemCount(): Int {
        return data.size()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        var view: View = LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.forecast_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data.get(position)
        holder.txtCity.text = data.city
        var list = data.temp.toArrayList();
        val today = list.remove(0)

        holder.txtTemp.text = "${today.current}ºC"

        val context = holder.itemView.context
        list.forEach { w ->
            /**
             * Don't this, just for test purpose :)
             */
            val view = LayoutInflater.from(context)
                    .inflate(R.layout.forecast_day_item,
                            holder.itemView as ViewGroup,
                            false)
            val txtDay = view.findViewById(R.id.txtDay) as TextView
            val txtMaxTemp = view.findViewById(R.id.txtMaxTemp) as TextView
            val txtMinTemp = view.findViewById(R.id.txtMinTemp) as TextView
            populateForecast(w, txtDay, txtMaxTemp, txtMinTemp)
            holder.layoutForecast.addView(view)
        }
    }

    private fun populateForecast(weather: Weather, txtDay: TextView, txtMaxTemp: TextView, txtMinTemp: TextView) {
        txtDay.text = DateUtil.dayOfWeek(weather.date).toUpperCase()
        txtMaxTemp.text = "${weather.max}ºC"
        txtMinTemp.text = "${weather.min}ºC"
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val txtCity: TextView by bindView(R.id.txtCity)
        val txtTemp: TextView by bindView(R.id.txtTempToday)
        val imgToday: ImageView by bindView(R.id.imgWeatherToday)
        val layoutForecast: LinearLayout by bindView(R.id.layoutForecast)
    }
}