package com.example.rickmorty.data.modelRealm

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class CharacterModel(): RealmObject {
    var id: Int = 0
    var name: String = ""
    var species: String = ""
    var gender: String = ""
    @PrimaryKey
    var idLocation : Int = 0
    var image: String = ""
    var nameLocation: String = "Unknown"
    var type: String = "Unknown"
    var dimension: String = "Unknown"
    var created: String = "Unknown"

    constructor(
        id: Int,
        name: String,
        species: String,
        gender: String,
        image: String,
        idLocation: Int,
        nameLocation: String,
        type: String,
        dimension: String,
        created: String
    ) : this() {
        this.id = id
        this.name = name
        this.species = species
        this.gender = gender
        this.image = image
        this.nameLocation = nameLocation
        this.type = type
        this.dimension = dimension
        this.created = created
        this.idLocation = idLocation
    }
}