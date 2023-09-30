package com.example.rickmortyapplicationmvvm.character_list.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.compose.ui.graphics.Color
import com.example.rickmortyapplicationmvvm.R
import com.example.rickmortyapplicationmvvm.character_details.view.CharacterDetailsActivity
import com.example.rickmortyapplicationmvvm.character_list.model.data.CharacterResponseUiModel
import com.example.rickmortyapplicationmvvm.databinding.AdapterCharecterBinding
import com.squareup.picasso.Picasso

class CharacterGridAdapter(private val context: Context, private val results: List<CharacterResponseUiModel>) : BaseAdapter() {




    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertVie: View?, parent: ViewGroup?): View {
        val binding: AdapterCharecterBinding
        var convertView = convertVie

        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(context)
            binding = AdapterCharecterBinding.inflate(layoutInflater, parent, false)
            convertView = binding.root
            convertView.tag = binding
        } else {
            binding = convertView.tag as AdapterCharecterBinding
        }

        val image = binding.imageIV
        val nameTV = binding.nameTV
        val statusTV = binding.statusTV

        nameTV.text = results[position].name
        statusTV.text = results[position].status

        Picasso.get().load(results[position].image).placeholder(R.drawable.character_placeholder).into(image)
        image.clipToOutline = true

        convertView.setOnClickListener {

                val intent = Intent(binding.root.context, CharacterDetailsActivity::class.java)
                intent.putExtra("character", results[position])
                binding.root.context.startActivity(intent)

        }

        return convertView
    }

    override fun getCount(): Int {
        return results.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}