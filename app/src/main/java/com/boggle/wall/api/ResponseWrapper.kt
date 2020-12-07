package com.boggle.wall.api

/**
 * Created by LIXK5 on 2018/9/28.
 */
data class ResponseWrapper<T>(var total: Int, var totalHits: Int, var hits: T?)