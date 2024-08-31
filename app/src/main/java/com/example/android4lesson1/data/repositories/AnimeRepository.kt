package com.example.android4lesson1.data.repositories

import com.example.android4lesson1.data.base.BaseRepository
import com.example.android4lesson1.data.remote.apiservices.DetailApiService
import com.example.android4lesson1.data.remote.apiservices.KitsuApiService
import com.example.android4lesson1.data.remote.apiservices.paging.AnimePagingSource
import javax.inject.Inject

class AnimeRepository
@Inject constructor(
    private val kitsuApiService: KitsuApiService,
    private val detailApiService: DetailApiService,
) : BaseRepository() {

    fun getAnime() = fetchData { AnimePagingSource(kitsuApiService) }

    fun getAnimeById(id: Int) = getAnimeById { detailApiService.getAnimeById(id).data }
}