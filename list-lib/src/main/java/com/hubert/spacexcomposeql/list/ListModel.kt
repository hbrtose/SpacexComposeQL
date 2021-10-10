package com.hubert.spacexcomposeql.list

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.hubert.spacexcomposeql.LaunchListQuery

interface ListModel {
    suspend fun getLaunches(): List<LaunchItem>
}

class ListModelImpl(private val apolloClient: ApolloClient) : ListModel {
    override suspend fun getLaunches(): List<LaunchItem> {
        return apolloClient.query(LaunchListQuery()).await().data?.launches?.launches
            ?.filterNotNull()
            ?.map {
                LaunchItem(it.id.toInt(), it.site ?: "", it.mission?.name ?: "", it.mission?.missionPatch ?: "")
            } ?: emptyList()
    }
}
