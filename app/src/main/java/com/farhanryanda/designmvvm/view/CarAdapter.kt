package com.farhanryanda.designmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhanryanda.designmvvm.databinding.ItemCarBinding
import com.farhanryanda.designpattern.model.ResponseCarItem

class CarAdapter(var listCar: List<ResponseCarItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameCar.text = listCar[position].name
        holder.binding.categoryCar.text = listCar[position].category
        holder.binding.priceCar.text = "Rp. " + listCar[position].price.toString()
        Glide.with(holder.itemView)
            .load(listCar[position].image)
            .into(holder.binding.imgCar)
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}