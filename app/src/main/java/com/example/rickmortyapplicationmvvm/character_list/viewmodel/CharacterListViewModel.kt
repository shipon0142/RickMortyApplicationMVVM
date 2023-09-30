package com.example.rickmortyapplicationmvvm.character_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickmortyapplicationmvvm.character_list.model.CharacterListModel
import com.example.rickmortyapplicationmvvm.character_list.model.CharacterListModelCallBack
import com.example.rickmortyapplicationmvvm.character_list.model.CharacterListModelImpl
import com.example.rickmortyapplicationmvvm.character_list.model.data.CharacterListResponse
import com.example.rickmortyapplicationmvvm.character_list.model.data.CharacterResponseUiModel

@Suppress("UNCHECKED_CAST")
class CharacterListViewModel(private val model: CharacterListModel) : ViewModel() {
    val showLoaderLiveData = MutableLiveData<Boolean>()
    val showErrorLiveData = MutableLiveData<String>()
    val characterListUiModelLiveData: MutableLiveData<List<CharacterResponseUiModel>> by lazy {
        MutableLiveData<List<CharacterResponseUiModel>>()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val model: CharacterListModel = CharacterListModelImpl()
                return CharacterListViewModel(model) as T
            }
        }
    }

    fun getCharacterList() {
        showLoaderLiveData.postValue(true)
        model.getCharacterList(object : CharacterListModelCallBack {
            override fun onSuccess(characterListResponse: CharacterListResponse) {
                val characterListUiModel =getCharacterListUiModelList(characterListResponse);
                showLoaderLiveData.postValue(false)
                characterListUiModelLiveData.postValue(characterListUiModel)
            }

            override fun onError(error: String) {
                showLoaderLiveData.postValue(false)
                showErrorLiveData.postValue(error)
            }

        }
        )


    }
    private fun getCharacterListUiModelList(characterListResponse: CharacterListResponse): List<CharacterResponseUiModel> {
        val characterUiModelList = mutableListOf<CharacterResponseUiModel>()

        characterListResponse.results.forEach {

            val blogUiModel = CharacterResponseUiModel(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                gender = it.gender,
                origin = it.origin.name,
                location = it.location.name,
                image = it.image

            )

            characterUiModelList.add(blogUiModel)
        }

        return characterUiModelList
    }




}