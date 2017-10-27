package br.com.bematech.gateway_android_client.model

/**
 * Created by Franklyn on 03/09/2017.
 */
/*class PrinterStatus(val drawaerStatus: Int,
                    val lowPaper: Int) {
}*/
class PrinterStatus : Status {
    override fun asList(): List<Pair<String, String>> {
        var list = mutableListOf<Pair<String, String>>()

        list.add(Pair("erro", erro))
        list.add(Pair("tampaAberta", tampaAberta))
        list.add(Pair("poucoPapel", poucoPapel))
        list.add(Pair("gavetaAberta", gavetaAberta))
        list.add(Pair("cabecaQuente", cabecaQuente))
        list.add(Pair("bufferCheio", bufferCheio))
        list.add(Pair("onLine", onLine))

        return list
    }

    var _id = ""
    var erro = ""
    var tampaAberta = ""
    var poucoPapel = ""
    var gavetaAberta = ""
    var cabecaQuente = ""
    var bufferCheio = ""
    var onLine = ""
    var __v = 0
}