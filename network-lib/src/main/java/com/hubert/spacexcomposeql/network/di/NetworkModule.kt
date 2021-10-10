package com.hubert.spacexcomposeql.network.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun provideApollo(): ApolloClient = ApolloClient.builder().serverUrl("https://apollo-fullstack-tutorial.herokuapp.com").build()
}
