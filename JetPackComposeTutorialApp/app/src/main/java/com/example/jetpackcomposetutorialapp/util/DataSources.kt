package com.example.jetpackcomposetutorialapp.util

import java.nio.file.attribute.GroupPrincipal

data class DataSources(
     val title:String?
)

fun dataList():List<DataSources>{
    return  listOf(
        DataSources(title = "Demo Recycler View with retrofit"),
        DataSources(title = "test data2"),
        DataSources(title = "test data3"),
        DataSources(title = "test data4")
    )
}