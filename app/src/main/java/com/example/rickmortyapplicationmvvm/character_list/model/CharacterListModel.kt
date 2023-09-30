package com.example.rickmortyapplicationmvvm.character_list.model

interface CharacterListModel {
    fun getCharacterList(callBack: CharacterListModelCallBack)
}