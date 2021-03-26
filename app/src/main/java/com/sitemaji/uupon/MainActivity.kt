package com.sitemaji.uupon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class MainActivity : AppCompatActivity() {

    companion object {

        const val TAG = "MainActivity";
        const val UNIT_ID = ""

    }

    private lateinit var mRewardedAd: RewardedAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initView()
        initAd()
    }

    fun initAd() {
        mRewardedAd = RewardedAd(this, UNIT_ID)
    }

    fun initView() {

        findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {
            v: View? ->

            var adRequest = AdRequest.Builder().build()

            RewardedAd.load(this, UNIT_ID, adRequest, object : RewardedAdLoadCallback() {

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    Log.d(TAG, rewardedAd.toString())
                    mRewardedAd = rewardedAd

                    mRewardedAd.show(this@MainActivity, OnUserEarnedRewardListener {

                        rewardItem: RewardItem ->  Unit

                    })
                }

            })

        })

    }

}