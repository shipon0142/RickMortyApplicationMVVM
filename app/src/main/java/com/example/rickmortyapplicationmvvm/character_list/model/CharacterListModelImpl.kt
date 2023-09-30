package com.example.rickmortyapplicationmvvm.character_list.model

import com.example.rickmortyapplicationmvvm.character_list.model.data.CharacterListResponse
import com.example.rickmortyapplicationmvvm.character_list.model.remote.CharacterListApiInterface
import com.example.rickmortyapplicationmvvm.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CharacterListModelImpl: CharacterListModel{


    private val characterListApiInterface = RetrofitClient.client.create<CharacterListApiInterface>()

    override fun getCharacterList(callBack: CharacterListModelCallBack) {
        val apiCall = characterListApiInterface.getCharacterList()

        apiCall.enqueue(object : Callback<CharacterListResponse>{

            override fun onResponse(
                call: Call<CharacterListResponse>,
                response: Response<CharacterListResponse>
            ) {
                val characterList = response.body()

                if (characterList?.results?.isEmpty() == true) {
                    callBack.onError("Content not found")
                } else {
                    callBack.onSuccess(characterList!!)
                }
            }

            override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {
                callBack.onError(t.message ?: "Something went wrong!")
            }


        })
    }
}