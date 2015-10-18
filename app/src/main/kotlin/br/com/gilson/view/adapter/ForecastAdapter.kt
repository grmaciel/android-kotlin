package br.com.gilson.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.gilson.R
import br.com.gilson.model.Forecast
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

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        holder?.txtTemp?.text = "${data.get(position).temp.current} ºC";
//        holder?.txtCity?.text = data.get(position).city;
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val txtCity: TextView by bindView(R.id.txtCity)
        val txtTemp: TextView by bindView(R.id.txtTempToday)
    }
}