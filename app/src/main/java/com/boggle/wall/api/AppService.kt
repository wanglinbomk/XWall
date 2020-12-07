package com.boggle.wall.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Streaming
import retrofit2.http.Url


/**
 * Created by LIXK5 on 2018/12/26.
 */
interface AppService {
   /* *//**
     * 查询app版本
     *
     * @return
     *//*
    @GET("/rf/appudpate/getVersionDetails")
    fun getAppVersion(): Observable<ResponseWrapper<MutableList<AppVersion>>>

    *//**
     * 查询app版本
     *
     * @return
     *//*
    @GET
    fun getAppVersionNew(@Url url : String): Observable<MutableList<AppVersionNew>>

    *//**
     * 下载文件
     *
     * @return
     *//*
    //    @Streaming
    //    @GET("/rf/appudpate/download")
    //    Observable<ResponseBody> downloadAPK(@QueryResponse("filename") String filename);
    @Streaming
    @Headers("Accept-Encoding: identity")
    @GET
    fun downloadAPK(@Url url: String): Observable<ResponseBody>

    *//**
     * 获取电子签列表
     * @param queryCode
     * @return
     *//*
    @GET("/rf/config/queryProjectType")
    fun queryProjectType(): Observable<ResponseWrapper<Any>>*/
}