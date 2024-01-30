package com.example.practica_3_deportistas_fragmentos_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels


class DetailFragment : Fragment() {
    private val futbolistaviewmodel: FutbolistaViewModel by activityViewModels()
    lateinit var v : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    // Creamos la funcion update para poder actualizar los datos desde el fragmento del listado a traves de la funcion del boton.
    public fun update(){
        // Completamos los detalles accediendo al futbolista elegido en el viewmodel de la actividad
        v.findViewById<TextView>(R.id.nombre_apar).text = this.futbolistaviewmodel.elegido?.nombre
        v.findViewById<TextView>(R.id.edad_apar).text = this.futbolistaviewmodel.elegido?.edad.toString()
        v.findViewById<TextView>(R.id.pos_apar).text = this.futbolistaviewmodel.elegido?.posicion
        v.findViewById<TextView>(R.id.titulos_apar).text = this.futbolistaviewmodel.elegido?.titulos.toString()
        v.findViewById<TextView>(R.id.descripcion_apar).text = this.futbolistaviewmodel.elegido?.descripcion
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail, container, false)
        // Cargamos los datos del jugador
        this.update()
        return v
    }

    companion object {

        fun newInstance() =
            DetailFragment().apply {
            }
    }
}