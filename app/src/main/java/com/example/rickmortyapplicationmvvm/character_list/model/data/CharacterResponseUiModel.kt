package com.example.rickmortyapplicationmvvm.character_list.model.data

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class CharacterResponseUiModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("image")
    val image: String
): Serializable {

}