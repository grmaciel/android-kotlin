package br.com.gilson.adapter

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
    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        var view: View = LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.forecast_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.txtCity.text = "City " + position;
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val txtCity: TextView by bindView(R.id.txtCity)
    }
}