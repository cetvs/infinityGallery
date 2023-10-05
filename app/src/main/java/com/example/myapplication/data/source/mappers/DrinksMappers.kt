package com.example.myapplication.data.source.mappers

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
