package com.hubert.spacexcomposeql.list

import android.renderscript.ScriptGroup
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.hubert.spacexcomposeql.LaunchListQuery

interface ListModel {
    suspend fun getLaunches(): List<LaunchItem>
}

class ListModelImpl(private val apolloClient: ApolloClient) : ListModel {

    private var cursor: String? = null
    private var hasMore = true

    override suspend fun getLaunches(): List<LaunchItem> {
        return if (hasMore) {
            apolloClient.query(LaunchListQuery(Input.fromNullable(cursor))).await().data?.launches
                ?.also {
                    cursor = it.cursor
                    hasMore = it.hasMore
                }
                ?.launches
                ?.filterNotNull()
                ?.map {
                    LaunchItem(it.id.toInt(), it.site ?: "", it.mission?.name ?: "", it.mission?.missionPatch ?: "")
                } ?: emptyList()
        } else {
            emptyList()
        }
    }
}
