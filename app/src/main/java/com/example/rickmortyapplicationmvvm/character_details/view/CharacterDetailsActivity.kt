package com.example.rickmortyapplicationmvvm.character_details.view

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.rickmortyapplicationmvvm.R
import com.example.rickmortyapplicationmvvm.character_list.model.data.CharacterResponseUiModel
import com.example.rickmortyapplicationmvvm.databinding.ActivityCharacterDetailsBinding
import com.squareup.picasso.Picasso

class CharacterDetailsActivity : ComponentActivity() {

    private lateinit var binding: ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val characterResponse = intent.getSerializableExtra("character") as CharacterResponseUiModel
        setAll(characterResponse)
        binding.backIV.setOnClickListener{
           finish()
        }

    }
    private fun setAll(character: CharacterResponseUiModel?) {
        binding.loadingLL.visibility = View.GONE
        binding.mainLLLL.visibility = View.VISIBLE
        binding.refreshSL.isRefreshing = false
        binding.nameTV.text = character!!.name
        binding.locationTV.text = character.location
        binding.speciesTV.text = character.species
        binding.genderTV.text = character.gender
        binding.originTV.text = character.origin
        binding.statusTV.text = character.status
        Picasso.get().load(character.image).into(binding.characterIV)
        Picasso.get().load(R.drawable.rick_morty_banner2).into(binding.backgroundIV)

    }


}