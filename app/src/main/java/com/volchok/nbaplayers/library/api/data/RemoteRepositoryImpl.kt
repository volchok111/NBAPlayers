package com.volchok.nbaplayers.library.api.data

//class RemoteRepositoryImpl(
//    private val nbaApi: NbaApi
//) : RemoteRepository {
//    override suspend fun getCharacters(): Data<List<PlayerModel>> {
//        return try {
//            val result = nbaApi.getPlayers().data
//            Data.Success(result)
//        } catch (ex: Exception) {
//            Data.Error(cause = ex)
//        }
//    }
//}