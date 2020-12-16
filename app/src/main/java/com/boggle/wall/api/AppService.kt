package com.boggle.wall.api

import com.boggle.wall.entity.DataEntity
import io.reactivex.Observable
import retrofit2.http.*


/**
 * Created by LIXK5 on 2018/12/26.
 */
interface AppService {
    @GET("/api")
    fun getData(
        @Query("key") key: String, @Query("q") q: String,
        @Query("image_type") image_type: String, @Query("orientation") orientation: String,
        @Query("category") category: String, @Query("colors") colors: String,
        @Query("editors_choice") editors_choice: Boolean, @Query("order") order: String,
        @Query("page") page: Int, @Query("per_page") per_page: Int): Observable<ResponseWrapper<MutableList<DataEntity>>>
}