package com.example.rickmortyapplicationmvvm.character_list.model

import com.example.rickmortyapplicationmvvm.character_list.model.data.CharacterListResponse

interface CharacterListModelCallBack {
    fun onSuccess(characterListResponse: CharacterListResponse)
    fun onError(error: String)
}