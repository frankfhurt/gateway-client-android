package br.com.bematech.gateway_android_client.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bematech.gateway_android_client.R
import br.com.bematech.gateway_android_client.adapter.StatusAdapter
import br.com.bematech.gateway_android_client.domain.StatusService
import br.com.bematech.gateway_android_client.model.PrinterStatus
import br.com.bematech.gateway_android_client.model.SatStatus
import br.com.bematech.gateway_android_client.model.Status
import kotlinx.android.synthetic.main.fragment_status.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class StatusFragment : BaseFragment() {

    private var statusType = "printer"

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        statusType = arguments.getSerializable("statusType") as String
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View?, icicle: Bundle?) {
        super.onViewCreated(view, icicle)
        // Views
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

        swiperefresh.setOnRefreshListener {
            showItems()
        }
    }

    override fun onResume() {
        super.onResume()

        showItems()
    }

    private fun showItems() {
        doAsync {

            var status : Status

            when (statusType) {
                "printer" -> status = StatusService.getPrinterStatus()
                "sat" -> status = StatusService.getSatStatus()
                else -> status = PrinterStatus()
            }

            uiThread {
                recyclerView.adapter = StatusAdapter(status.asList())
                swiperefresh.isRefreshing = false
            }
        }
    }
}
