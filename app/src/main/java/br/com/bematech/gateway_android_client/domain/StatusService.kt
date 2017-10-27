package br.com.bematech.gateway_android_client.domain

import android.util.Log
import br.com.bematech.gateway_android_client.Util.HttpHelper
import br.com.bematech.gateway_android_client.extensions.fromJson
import br.com.bematech.gateway_android_client.model.PrinterStatus
import br.com.bematech.gateway_android_client.model.SatStatus
import okhttp3.Response

/**
 * Created by frank on 26/10/2017.
 */
object StatusService {

    private val BASE_URL = "http://ec2-13-58-199-68.us-east-2.compute.amazonaws.com:8080"

    fun getPrinterStatus(): PrinterStatus {
        val url = "$BASE_URL/printerStatus"
        val json = HttpHelper.get(url)
        Log.d("PrinterStatus", json)

        return fromJson(json)
    }

    fun getSatStatus() : SatStatus {
        val url = "$BASE_URL/satStatus"
        val json = HttpHelper.get(url)
        Log.d("PrinterStatus", json)

        return fromJson(json)
    }

    fun save(): Response {
        val json = HttpHelper.post(BASE_URL, "")
        val response = fromJson<Response>(json)

        return response
    }
}