package com.acv.buycoffee

import android.util.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import org.web3j.abi.datatypes.Address
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract
import org.web3j.tx.Transfer
import org.web3j.utils.Convert
import java.math.BigDecimal
import kotlin.coroutines.resume


suspend fun main() {
    val credentials: Map<String, Credentials> = mapOf(
        "0xdF9E58E0D0bF39783A3ccd0A798B18d3C11CbcCF".toLowerCase() to Credentials.create("99dc03d0320e5a782204977b98f05c2c58f108da496e01be7f21fe3e70059e2d"),
        "0xEF58735d75d74108996B47194BD03298731a7614".toLowerCase() to Credentials.create("a8edd0c3293a1dc895d8871554b02d5dda337ca4f7bfbb326bebb07208999937"),
        "0x245387E69CeAacE1d879bA992a0D2b402FCceA8C".toLowerCase() to Credentials.create("5ed9688ef4493bd9b0fb888db2e45a7315596d6257255bfba4d1015b2ed05dea")
    )

    val web3 = Web3j.build(HttpService("HTTP://192.168.1.2:7545"))
//  val web3j = Web3j.build(HttpService("https://rinkeby.infura.io/v3/4f1f53e6cc5d456aa4e0c4c5de5639db"))
//  val web3j = Web3j.build(HttpService("https://api.myetherapi.com/eth"))

    val credential: Credentials = credentials.get("0xdF9E58E0D0bF39783A3ccd0A798B18d3C11CbcCF".toLowerCase())!!

    val contract = BuyMeACoffee.deploy(
        web3,
        credential,
        Contract.GAS_PRICE,
        Contract.GAS_LIMIT,
    ).sendAsync().get()

    Log.e("BuyMeACoffee deployed to:", contract.contractAddress)

    printBalances(credentials.values.toList().map { it.address })


}

suspend fun Web3j.getBalance(address: String): Long = suspendCancellableCoroutine {
    it.resume(Convert.toWei(ethGetBalance(address, DefaultBlockParameterName.LATEST).send().balance.toString(), Convert.Unit.ETHER).toLong())
}

suspend fun Web3j.printMemos(memos: List<BuyMeACoffee.Memo>) {
    memos.forEach { memo ->
        val timestamp = memo.timestamp
        val tipper = memo.name
        val tipperAddress = memo.from
        val message = memo.message
        Log.e("sadf", """At ${timestamp}, ${tipper} (${tipperAddress}) said: "$message""")
    }
}


// Logs the Ether balances for a list of addresses.
suspend fun printBalances(addresses: List<String>) {
}
