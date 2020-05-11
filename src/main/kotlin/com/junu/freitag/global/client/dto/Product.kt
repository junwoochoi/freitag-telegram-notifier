package com.junu.freitag.global.client.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(
        @JsonProperty("neo_product_colors")
        val neoProductColors: String,
        @JsonProperty("neo_product_cover_photo")
        val neoProductCoverPhoto: NeoProductCoverPhoto,
        @JsonProperty("product_id")
        val productId: String,
        val sku: String,
        val title: String
)