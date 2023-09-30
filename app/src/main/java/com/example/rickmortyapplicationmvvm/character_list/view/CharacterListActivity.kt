package com.example.rickmortyapplicationmvvm.character_list.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.rickmortyapplicationmvvm.R
import com.example.rickmortyapplicationmvvm.character_list.viewmodel.CharacterListViewModel
import com.example.rickmortyapplicationmvvm.databinding.ActivityCharacterListBinding

class CharacterListActivity : ComponentActivity() {

    private lateinit var binding: ActivityCharacterListBinding
    private val viewModel: CharacterListViewModel by viewModels { CharacterListViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.refreshLL.isRefreshing=false
        viewModel.getCharacterList()



        viewModel.characterListUiModelLiveData.observe(this) {

            val adapter = CharacterGridAdapter(this, it)
            binding.characterGV.adapter = adapter
            binding.characterGV.isExpanded=true


        }


    }

}