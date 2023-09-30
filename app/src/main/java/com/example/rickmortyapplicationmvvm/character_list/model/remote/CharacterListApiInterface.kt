package com.example.rickmortyapplicationmvvm.character_list.model.remote

import com.example.rickmortyapplicationmvvm.character_list.model.data.CharacterListResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterListApiInterface {

    @GET("character")
    fun getCharacterList() : Call<CharacterListResponse>
}