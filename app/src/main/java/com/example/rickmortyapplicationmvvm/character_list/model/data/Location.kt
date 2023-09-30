package com.example.rickmortyapplicationmvvm.character_list.model.data

import com.google.gson.annotations.SerializedName


data class Location (

  @SerializedName("name")
  val name : String,
  @SerializedName("url")
  val url  : String

)