package com.example.rubicscubelearning

import android.os.CountDownTimer

abstract class CountUpTimer(private val millisecondsInFuture: Int, countUpIntervalMilliseconds: Int) : CountDownTimer(millisecondsInFuture.toLong() * 10, countUpIntervalMilliseconds.toLong() * 10) {

    abstract fun onCount(count: Int)

    override fun onTick(msUntilFinished: Long) {
        onCount(((millisecondsInFuture.toLong() * 10 - msUntilFinished) / 10).toInt())
    }
}