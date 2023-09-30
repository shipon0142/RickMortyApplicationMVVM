package com.example.rickmortyapplicationmvvm.character_list.model.data

import com.google.gson.annotations.SerializedName


data class CharacterListResponse(

    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: ArrayList<Results> = arrayListOf()

)