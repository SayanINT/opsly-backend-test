package com.example.opslytest.component

import com.example.opslytest.model.Twitter
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Component


@Component
class TwitterComponent() {
    val httpClient: OkHttpClient = OkHttpClient()
    val requestBuilder = Request.Builder()
            .url("https://takehome.io/twitter")
            .build()

    fun getData(): List<Twitter> {
        httpClient.newCall(requestBuilder)
                .execute().use { response ->
                    if (response.code == 200) {
                        return jacksonObjectMapper().readValue(response.body!!.string())
                    }else{
                        return emptyList()
                    }
                }
    }
}