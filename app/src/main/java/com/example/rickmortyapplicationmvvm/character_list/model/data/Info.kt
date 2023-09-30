package com.example.rickmortyapplicationmvvm.character_list.model.data

import com.google.gson.annotations.SerializedName


data class Info (

  @SerializedName("count")
  val count : Int,
  @SerializedName("pages")
  val pages : Int,
  @SerializedName("next")
  val next  : String,
  @SerializedName("prev")
  var prev  : String

)