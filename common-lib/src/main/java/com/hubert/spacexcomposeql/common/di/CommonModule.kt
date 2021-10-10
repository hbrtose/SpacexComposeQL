package com.hubert.spacexcomposeql.common.di

import com.hubert.spacexcomposeql.common.provider.DispatcherProvider
import com.hubert.spacexcomposeql.common.provider.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class CommonModule {

    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = DispatcherProviderImpl()
}
