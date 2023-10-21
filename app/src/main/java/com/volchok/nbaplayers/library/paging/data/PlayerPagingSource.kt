package com.volchok.nbaplayers.library.paging.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.volchok.nbaplayers.library.api.data.NbaApi
import com.volchok.nbaplayers.library.api.model.PlayerModel

class PlayerPagingSource(
    private val nbaApi: NbaApi
) : PagingSource<Int, PlayerModel>() {
    override fun getRefreshKey(state: PagingState<Int, PlayerModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PlayerModel> {
        return try {
            val page = params.key ?: 1
            val response = nbaApi.getPlayers(page)

            LoadResult.Page(
                data = response.data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.data.isEmpty()) null else response.meta.next_page
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}