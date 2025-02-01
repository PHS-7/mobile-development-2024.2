package com.io.crupapp2.model

data class Item(
    val id: String = generateId().toString(),
    val title: String,
    val description: String,

    ){
    companion object {
        private var currentId = 0

        fun generateId(): Int{
            return currentId++
        }
    }
}