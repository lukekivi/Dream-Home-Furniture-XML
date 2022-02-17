package com.dreamhomefurniturexml.data

import com.dreamhomefurniturexml.network.FurnitureData

sealed class FurnitureResponse {
    object Uninitialized : FurnitureResponse()
    class Success(val simpleFurnitureDataList: List<FurnitureData>) : FurnitureResponse()
    class Error(val message: String) : FurnitureResponse()
}
