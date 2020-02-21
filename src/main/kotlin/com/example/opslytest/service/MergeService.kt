package com.example.opslytest.service

import com.example.opslytest.component.FacebookComponent
import com.example.opslytest.component.InstagramComponent
import com.example.opslytest.component.TwitterComponent
import com.example.opslytest.model.Facebook
import com.example.opslytest.model.Instagram
import com.example.opslytest.model.CombinedMainModel
import com.example.opslytest.model.Twitter
import org.springframework.stereotype.Service


@Service
class MergeService() {
    fun get() : CombinedMainModel {
        var tw: List<Twitter> = TwitterComponent().getData()
        var fb: List<Facebook> = FacebookComponent().getData()
        var ins: List<Instagram> = InstagramComponent().getData()

        return CombinedMainModel(
                twitter =  tw,
                facebook= fb,
                instagram = ins
        )
    }
}