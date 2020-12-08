package com.boggle.wall.http

import android.content.Context
import com.boggle.wall.api.ResponseWrapper
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *
 * 把原版本的加载框去掉
 *
 * Created by LIXK5 on 2018/9/28.
 * Copy by wuqx14 on 2020/9/28.
 */
abstract class RequestCallbackV2<T>(private val context: Context) : Observer<ResponseWrapper<T>> {

    abstract fun success(data: T?)
    abstract fun failure(msg: String)

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: ResponseWrapper<T>) {
        if (t.total > 0) {
            success(t.hits)
        } else {
            failure("no_data")
        }
    }

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {

    }
}