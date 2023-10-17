package com.volchok.nbaplayers.library.api.model

data class Meta(
    val current_page: Int,
    val next_page: Int,
    val per_page: Int,
    val total_count: Int,
    val total_pages: Int
)