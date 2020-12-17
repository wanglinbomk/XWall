package com.boggle.wall.moudle.main.fragment.home.item

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
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bind
import com.trello.rxlifecycle2.kotlin.bindUntilEvent

class FirstViewModel : ViewModel() {

    private var mData: MutableLiveData<MutableList<DataEntity>>? = null
    private var mHeadData: MutableLiveData<MutableList<DataEntity>>? = null
    private var mHorizontal: MutableLiveData<MutableList<DataEntity>>? = null

    fun loadHeadData(activity: FragmentActivity): MutableLiveData<MutableList<DataEntity>> {
        if (mHeadData == null) {
            mHeadData = MutableLiveData()
        }
        RetrofitHelper.getAppAPI().getData(
            Constants.BASE_KEY, Constants.REQUEST_Q, Constants.REQUEST_DEFAULT,
            Constants.REQUEST_HORIZONTAL, RequestUtils.getInstance().randomCategory, "", false,
            "", RequestUtils.getInstance().bannerRandom, 5
        )
            .compose(NetworkScheduler.compose())
            .subscribe(object : RequestCallbackV2<MutableList<DataEntity>>(activity) {
                override fun success(data: MutableList<DataEntity>?) {
                    mHeadData?.postValue(data)
                }

                override fun failure(msg: String) {
                    mHeadData?.postValue(mutableListOf())
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
        activity: MainActivity,
        q: String,
        image_type: String,
        orientation: String,
        category: String,
        colors: String,
        editors_choice: Boolean,
        order: String,
        page: Int,
        per_page: Int
    ): MutableLiveData<MutableList<DataEntity>> {
        if (mData == null) {
            mData = MutableLiveData()
        }
        RetrofitHelper.getAppAPI().getData(
            Constants.BASE_KEY, q, image_type, orientation, category, colors,
            editors_choice, order, page, per_page
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