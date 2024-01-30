package com.example.practica_3_deportistas_fragmentos_viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FutbolistaRecylerViewAdapter(var futbolistas : List<Futbolista>) : RecyclerView.Adapter<FutbolistaRecylerViewAdapter.ViewHolder>() {
    // Esta variable hace referencia a una funcion.
    var click: ((Int, Futbolista) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item_number: TextView
        val content : TextView
        val button : Button
        init {
            item_number = view.findViewById(R.id.item_number)
            content = view.findViewById(R.id.content)
            button = view.findViewById(R.id.button)
        }
    }

    //  Crea la vista inflandole el layout del item
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Gestiona el contenido de la vista
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.item_number.text = position.toString()
        viewHolder.content.text = futbolistas[position].nombre
        viewHolder.button.setOnClickListener(){
            // Cuando hagamos click en el boton llamara a la funcion que esta almacenada.
            this.click?.let { abrirDetalle -> abrirDetalle(position, futbolistas[position]) }
        }
    }

    override fun getItemCount() = futbolistas.size

}