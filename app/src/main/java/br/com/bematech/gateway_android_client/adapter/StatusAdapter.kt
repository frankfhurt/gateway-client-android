package br.com.bematech.gateway_android_client.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bematech.gateway_android_client.R
import kotlinx.android.synthetic.main.adapter_status.view.*

/**
 * Created by Franklyn on 03/09/2017.
 */
class StatusAdapter(val listStatus: List<Pair<String, String>>) : RecyclerView.Adapter<StatusAdapter.PrinterViewHolder>() {

    class PrinterViewHolder(view: View): RecyclerView.ViewHolder(view) {
    }

    override fun getItemCount() = listStatus.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrinterViewHolder {
        return PrinterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_status, parent, false))
    }

    override fun onBindViewHolder(holder: PrinterViewHolder, position: Int) {
        val status = listStatus[position]
        val view = holder.itemView

        with(view) {
            status_name.text = status.first
            progress.visibility = View.VISIBLE

            when (status.second) {
                "0" -> {
                    status_value_switch.visibility = View.VISIBLE
                    status_value.visibility = View.GONE
                    status_value_switch.isChecked = false
                }
                "1" -> {
                    status_value_switch.visibility = View.VISIBLE
                    status_value.visibility = View.GONE
                    status_value_switch.isChecked = true
                }
                else -> {
                    status_value_switch.visibility = View.GONE
                    status_value.visibility = View.VISIBLE
                    status_value.text = status.second
                }
            }

            progress.visibility = View.INVISIBLE
        }
    }
}