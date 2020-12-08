package com.boggle.wall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.boggle.wall.entity.DataEntity
import com.boggle.wall.http.NetworkScheduler
import com.boggle.wall.http.RequestCallbackV2
import com.boggle.wall.http.RetrofitHelper
import com.boggle.wall.utils.Constants
import com.trello.rxlifecycle2.kotlin.bindUntilEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitHelper.getAppAPI().getData(
            Constants.BASE_KEY, "city", "", "", "", "",
            false, "", 1, 20)
            .compose(NetworkScheduler.compose())
            .subscribe(object : RequestCallbackV2<DataEntity>(this) {
                override fun success(data: DataEntity?) {
                    Log.i("xyz",data.toString())
                }

                override fun failure(msg: String) {
                    Log.i("xyz",msg);
                }
            })
    }
}