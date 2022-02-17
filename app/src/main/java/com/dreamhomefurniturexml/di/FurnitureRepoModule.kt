package com.dreamhomefurniturexml.di

import com.dreamhomefurniturexml.data.FurnitureRepo
import com.dreamhomefurniturexml.data.FurnitureRepoImpl
import com.dreamhomefurniturexml.network.FurnitureNetworkService
import com.dreamhomefurniturexml.network.FurnitureNetworkServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface FurnitureRepoModule {

    @Binds
    fun bindsFurnitureNetworkService(furnitureNetworkService: FurnitureNetworkServiceImpl): FurnitureNetworkService

    @Binds
    fun bindsFurnitureRepository(furnitureRepo: FurnitureRepoImpl): FurnitureRepo
}