package br.com.bematech.gateway_android_client.fragment

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bematech.gateway_android_client.R
import br.com.bematech.gateway_android_client.adapter.StatusAdapter
import br.com.bematech.gateway_android_client.model.PrinterStatus
import kotlinx.android.synthetic.main.fragment_status.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class StatusFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View?, icicle: Bundle?) {
        super.onViewCreated(view, icicle)
        // Views
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()

        doAsync {
            val status = PrinterStatus(1, 0)
            val listStatus = ArrayList<Pair<String, Int>>()

            listStatus.add(Pair("drawerStatus", status.drawaerStatus))
            listStatus.add(Pair("lowPaper", status.lowPaper))

            uiThread {
                recyclerView.adapter = StatusAdapter(listStatus)
            }
        }
    }
}
