package com.hubert.spacexcomposeql.list.di

import com.apollographql.apollo.ApolloClient
import com.hubert.spacexcomposeql.list.ListModel
import com.hubert.spacexcomposeql.list.ListModelImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class ListModule {

    @Provides
    fun provideListModel(apolloClient: ApolloClient): ListModel = ListModelImpl(apolloClient)
}
