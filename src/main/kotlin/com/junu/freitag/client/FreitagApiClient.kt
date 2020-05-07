package com.junu.freitag.client

import com.junu.freitag.dto.ResponseFreitagProducts
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "freitag-api-client", url = "\${freitag.url}")
interface FreitagApiClient {
    @RequestMapping(method = [RequestMethod.GET], path = ["/json/model/{modelNumber}/products/0/0"])
    fun findStocks(@PathVariable("modelNumber") modelNumber: String): ResponseFreitagProducts
}