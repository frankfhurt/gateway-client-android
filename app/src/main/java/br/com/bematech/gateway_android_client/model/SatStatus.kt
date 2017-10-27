package br.com.bematech.gateway_android_client.model

/**
 * Created by Franklyn on 03/09/2017.
 */
class SatStatus : Status {

    override fun asList(): List<Pair<String, String>> {
        var list = mutableListOf<Pair<String, String>>()

        list.add(Pair("numeroSessao", numeroSessao))
        list.add(Pair("codigoDeRetorno", codigoDeRetorno))
        list.add(Pair("mensagemDeRetorno", mensagemDeRetorno))
        list.add(Pair("codigoMensagemSefaz", codigoMensagemSefaz))
        list.add(Pair("mensagemDaSefaz", mensagemDaSefaz))
        list.add(Pair("numeroDeSerie", numeroDeSerie))
        list.add(Pair("tipoDaLan", tipoDaLan))
        list.add(Pair("ip", ip))
        list.add(Pair("mascaraDeRede", mascaraDeRede))
        list.add(Pair("gateway", gateway))
        list.add(Pair("dnsPrimario", dnsPrimario))
        list.add(Pair("dnsSecundario", dnsSecundario))
        list.add(Pair("statusDaLan", statusDaLan))
        list.add(Pair("nivelDaBateria", nivelDaBateria))
        list.add(Pair("totalDeMemoria", totalDeMemoria))
        list.add(Pair("memoriaUtilizada", memoriaUtilizada))
        list.add(Pair("dataHoraAtual", dataHoraAtual))
        list.add(Pair("versaoSoftwareBasico", versaoSoftwareBasico))
        list.add(Pair("versaoLayout", versaoLayout))
        list.add(Pair("ultimoCFeEnviado", ultimoCFeEnviado))
        list.add(Pair("primeiroCFeArmazenado", primeiroCFeArmazenado))
        list.add(Pair("ultimoCFeArmazenado", ultimoCFeArmazenado))
        list.add(Pair("ultimaTransmissaoDeCFe", ultimaTransmissaoDeCFe))
        list.add(Pair("ultimaComunicacaoComSefaz", ultimaComunicacaoComSefaz))
        list.add(Pair("emissaoDoCertificado", emissaoDoCertificado))
        list.add(Pair("vencimentoDoCertificado", vencimentoDoCertificado))
        list.add(Pair("estadoDeOperacao", estadoDeOperacao))

        return list
    }

    var _id = "59e298201393f31a30d47cac"
    var numeroSessao = "8907"
    var codigoDeRetorno = "10000"
    var mensagemDeRetorno = "Resposta com Sucesso"
    var codigoMensagemSefaz = ""
    var mensagemDaSefaz = ""
    var numeroDeSerie = "900013449"
    var tipoDaLan = "DHCP"
    var ip = "192.168.000.122"
    var mascaraDeRede = "255.255.255.000"
    var gateway = "192.168.000.001"
    var dnsPrimario = "192.168.000.001"
    var dnsSecundario = "000.000.000.000"
    var statusDaLan = "CONECTADO"
    var nivelDaBateria = "ALTO"
    var totalDeMemoria = "1,74 GB"
    var memoriaUtilizada = "0,98 GB"
    var dataHoraAtual = "16/08/2017 10:31:23"
    var versaoSoftwareBasico = "02.01.01"
    var versaoLayout = "0.07"
    var ultimoCFeEnviado = "00000000000000000000000000000000000000000000"
    var primeiroCFeArmazenado = "00000000000000000000000000000000000000000000"
    var ultimoCFeArmazenado = "00000000000000000000000000000000000000000000"
    var ultimaTransmissaoDeCFe = "16/08/2017 10:28:40"
    var ultimaComunicacaoComSefaz = "16/08/2017 10:28:40"
    var emissaoDoCertificado = "15/08/2017"
    var vencimentoDoCertificado = "15/08/2022"
    var estadoDeOperacao = "0"
    var __v = 0
}