package com.example.myapplication.data.source.mappers

import com.example.myapplication.data.source.local.AppDao
import com.example.myapplication.data.source.local.DrinkInfoEntity
import com.example.myapplication.domain.model.DrinkInfoRemote

fun DrinkInfoRemote.toDrinkInfoEntity(): DrinkInfoEntity {
    return DrinkInfoEntity(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        isFavorite = false
    )
}

//fun DrinkInfoRemote.toDrink(): Beer {
//    return Beer(
//        id = id,
//        name = name,
//        tagline = tagline,
//        description = description,
//        firstBrewed = firstBrewed,
//        imageUrl = imageUrl
//    )
//}