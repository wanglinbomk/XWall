package com.boggle.wall.http

import android.content.Context
import com.boggle.wall.api.AppService
import com.boggle.wall.api.LoggerInterceptor2
import com.boggle.wall.utils.Constants
import com.google.gson.*
import com.readystatesoftware.chuck.ChuckInterceptor
import me.jessyan.progressmanager.ProgressManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

/**
 * Created by LIXK5 on 2018/9/28.
 */
object RetrofitHelper {
    private lateinit var okHttpClient: OkHttpClient

    fun getAppAPI(): AppService {
        return createApi(AppService::class.java, Constants.BASE_URL)
    }

    fun initOkHttpClient(context: Context) {
        okHttpClient = ProgressManager.getInstance()
                .with(OkHttpClient.Builder())
                .retryOnConnectionFailure(true)
                .connectTimeout(20000, TimeUnit.MILLISECONDS)
                .readTimeout(20000, TimeUnit.MILLISECONDS)
                .writeTimeout(20000, TimeUnit.MILLISECONDS)
                .addInterceptor(LoggerInterceptor2("", true))
                .addInterceptor(ChuckInterceptor(context))
                .hostnameVerifier(HostnameVerifier { hostname, session -> true })
                .build()
    }

    private fun <T> createApi(clazz: Class<T>, baseUrl: String): T {
        val gsonBuilder = GsonBuilder()
        gsonBuilder
                .registerTypeAdapter(Date::class.java, DateDeserializer()).setDateFormat(DateFormat.LONG)
                .registerTypeAdapter(Integer::class.java, IntegerDefault0Adapter())
                .registerTypeAdapter(Int::class.java, IntegerDefault0Adapter())
                .setDateFormat("yyyy-MM-dd")


        val gson = gsonBuilder.create()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return retrofit.create(clazz)
    }

    /**
     * Gson Integer和int类型适配器
     */
    private class IntegerDefault0Adapter : JsonSerializer<Int>, JsonDeserializer<Int> {

        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Int? {
            try {
                if (json.asString == "" || json.asString == "null") {//定义为int类型,如果后台返回""或者null,则返回0
                    return 0
                }
            } catch (ignore: Exception) {
            }

            try {
                return json.asInt
            } catch (e: NumberFormatException) {
                throw JsonSyntaxException(e)
            }

        }

        override fun serialize(src: Int?, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
            return JsonPrimitive(src!!)
        }
    }

    /**
     * Long转日期
     */
    private class DateDeserializer : JsonDeserializer<Date> {
        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date {
            return Date(json!!.asJsonPrimitive!!.asLong)
        }
    }
}