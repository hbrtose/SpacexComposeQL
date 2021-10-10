package com.hubert.spacexcomposeql.detail

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.hubert.spacexcomposeql.LaunchDetailsQuery

interface DetailModel {
    suspend fun getDetail(id: Int): DetailItem?
}

class DetailModelImpl(private val apolloClient: ApolloClient) : DetailModel {
    override suspend fun getDetail(id: Int): DetailItem? {
        return apolloClient.query(LaunchDetailsQuery(id.toString())).await().data?.launch?.let {
            DetailItem(
                it.site ?: "",
                it.rocket?.name ?: "",
                it.rocket?.type ?: "",
                it.isBooked,
                it.mission?.name ?: "",
                it.mission?.missionPatch ?: ""
            )
        }
    }
}
