#!/usr/bin/env groovy
@Grab('org.ethereumclassic:etherjar:0.4.0')
import org.ethereumclassic.etherjar.model.Address
import org.ethereumclassic.etherjar.rpc.DefaultRpcClient
import org.ethereumclassic.etherjar.rpc.json.BlockTag
import org.ethereumclassic.etherjar.rpc.transport.DefaultRpcTransport

def eth = new DefaultRpcClient(new DefaultRpcTransport(new URI("http://127.0.0.1:8545"))).eth()

def req = eth.getBalance(Address.from("0x00a329c0648769a73afac7f9381e08fb43dbea72"), BlockTag.LATEST)

println "Test account balance: ${req.get()}"
