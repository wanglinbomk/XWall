package com.boggle.wall.moudle.main.fragment.home.fhome

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.boggle.wall.entity.DataEntity
import com.boggle.wall.http.NetworkScheduler
import com.boggle.wall.http.RequestCallbackV2
import com.boggle.wall.http.RetrofitHelper
import com.boggle.wall.utils.Constants
import com.boggle.wall.utils.RequestUtils
import com.readystatesoftware.chuck.internal.ui.MainActivity

class FirstViewModel : ViewModel() {

    private var mData: MutableLiveData<MutableList<DataEntity>>? = null
    private var mHeadData: MutableLiveData<MutableList<DataEntity>>? = null
    private var mHorizontal: MutableLiveData<MutableList<DataEntity>>? = null

    private var page = 1
    private var pageSize = 50

    fun loadHeadData(activity: FragmentActivity): MutableLiveData<MutableList<DataEntity>> {
        if (mHeadData == null) {
            mHeadData = MutableLiveData()
        }
        RetrofitHelper.getAppAPI().getData(
            Constants.BASE_KEY, Constants.REQUEST_Q, Constants.REQUEST_DEFAULT,
            Constants.REQUEST_HORIZONTAL, RequestUtils.getInstance().randomCategory, "", false,
            "", RequestUtils.getInstance().bannerRandom, 4
        )
            .compose(NetworkScheduler.compose())
            .subscribe(object : RequestCallbackV2<MutableList<DataEntity>>(activity) {
                override fun success(data: MutableList<DataEntity>?) {
                    if (data?.size != 0) {
                        mHeadData?.postValue(data)
                    } else {
                        loadHeadData(activity)
                    }
                }

                override fun failure(msg: String) {
                    loadHeadData(activity)
                }
            })

        return mHeadData as MutableLiveData<MutableList<DataEntity>>
    }

    fun loadHorizontal(activity: FragmentActivity): MutableLiveData<MutableList<DataEntity>> {
        if (mHorizontal == null) {
            mHorizontal = MutableLiveData()
        }
        RetrofitHelper.getAppAPI().getData(
            Constants.BASE_KEY, "", Constants.REQUEST_DEFAULT,
            Constants.REQUEST_VERTICAL, RequestUtils.getInstance().titleKey, "", false,
            "", RequestUtils.getInstance().random, 8
        )
            .compose(NetworkScheduler.compose())
            .subscribe(object : RequestCallbackV2<MutableList<DataEntity>>(activity) {
                override fun success(data: MutableList<DataEntity>?) {
                    mHorizontal?.postValue(data)
                }

                override fun failure(msg: String) {
                    mHorizontal?.postValue(mutableListOf())
                }
            })
        return mHorizontal as MutableLiveData<MutableList<DataEntity>>
    }

    fun loadData(
        activity: FragmentActivity
    ): MutableLiveData<MutableList<DataEntity>> {
        if (mData == null) {
            mData = MutableLiveData()
        }
        RetrofitHelper.getAppAPI().getData(
            Constants.BASE_KEY,
            "",
            Constants.REQUEST_DEFAULT,
            Constants.REQUEST_VERTICAL,
            RequestUtils.getInstance().bottomCategory,
            "",
            false,
            "",
            page,
            pageSize
        )
            .compose(NetworkScheduler.compose())
            .subscribe(object : RequestCallbackV2<MutableList<DataEntity>>(activity) {
                override fun success(data: MutableList<DataEntity>?) {
                    mData?.postValue(data)
                }

                override fun failure(msg: String) {
                    mData?.postValue(mutableListOf())
                }
            })
        return mData as MutableLiveData<MutableList<DataEntity>>
    }

}