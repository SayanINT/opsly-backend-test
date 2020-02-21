package com.example.opslytest.component

import com.example.opslytest.model.Facebook
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Component


@Component
class FacebookComponent()  {
    var httpClient: OkHttpClient = OkHttpClient()
    val requestBuilder = Request.Builder()
            .url("https://takehome.io/facebook")
            .build()

    fun getData(): List<Facebook> {
        httpClient.newCall(requestBuilder)
                .execute().use {
                    response ->
                    if (response.code == 200) {
                        return  jacksonObjectMapper().readValue(response.body!!.string())
                    }else{
                        return emptyList()
                    }
                }
    }

}