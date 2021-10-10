package com.hubert.spacexcomposeql.detail.di

import com.apollographql.apollo.ApolloClient
import com.hubert.spacexcomposeql.detail.DetailModel
import com.hubert.spacexcomposeql.detail.DetailModelImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class DetailModule {

    @Provides
    fun provideDetailModel(apolloClient: ApolloClient): DetailModel = DetailModelImpl(apolloClient)
}
