package com.example.dreamhomefurniturecompose.di

import com.example.dreamhomefurniturecompose.data.FurnitureRepo
import com.example.dreamhomefurniturecompose.data.FurnitureRepoImpl
import com.example.dreamhomefurniturecompose.network.FurnitureNetworkService
import com.example.dreamhomefurniturecompose.network.FurnitureNetworkServiceImpl
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