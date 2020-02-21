package com.example.opslytest.controller

import com.example.opslytest.service.MergeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(val mergeService: MergeService) {

    @GetMapping("/")
    fun getData() = mergeService.get()
}

