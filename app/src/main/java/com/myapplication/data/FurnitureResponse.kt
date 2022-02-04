package com.example.dreamhomefurniturecompose.data

import com.example.dreamhomefurniturecompose.network.FurnitureData

sealed class FurnitureResponse {
    object Uninitialized : FurnitureResponse()
    class Success(val simpleFurnitureDataList: List<FurnitureData>) : FurnitureResponse()
    class Error(val message: String) : FurnitureResponse()
}
