#!/usr/bin/env groovy
@Grab('org.ethereumclassic:etherjar:0.4.0')
import org.ethereumclassic.etherjar.rpc.transport.DefaultRpcTransport

def req = new DefaultRpcTransport(["http://127.0.0.1:8545"] as URI)
        .execute("web3_clientVersion", Collections.EMPTY_LIST, String.class)

println "Client version: ${req.get()}"
