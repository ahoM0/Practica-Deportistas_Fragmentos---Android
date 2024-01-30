package com.example.practica_3_deportistas_fragmentos_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager

class ListFragment : Fragment() {
    // Definimos la variable que hace relacion a la clase viewmodel de la actividad.
    private val futbolistaviewmodel: FutbolistaViewModel by activityViewModels()
    lateinit var v : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        // RecycleView
        var recyclerview : RecyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        // Adaptador
        var adaptador = FutbolistaRecylerViewAdapter(this.futbolistaviewmodel.futbolistas)

        // Gestionamos el click del boton del listado
        adaptador.click = { position, futbolista ->
            run{
                // Seleccionamos el futbolista del viewmodel de la actividad para acceder a el desde el fragmento de detalles
                this.futbolistaviewmodel.elegido = futbolista
                val fm: FragmentManager = parentFragmentManager
                // Si la rotacion es horizontal entonces actualizamos el fragmento de detalles cada vez que hacen click en un jugador.
                if (resources.getBoolean(R.bool.land)){
                    val contenedor = v.findViewById<FragmentContainerView>(R.id.detailfragmentContainerView)
                    val fragmentManager = childFragmentManager
                    var fragment= fragmentManager.findFragmentById(contenedor?.id ?: -1)
                    if(fragment!=null && fragment is DetailFragment){
                        (fragment as DetailFragment).update()
                    }
                }else{// SI esta en modo vertical cambiamos el fragmento por el de detalles y ya.
                    val transaction = fm.beginTransaction()
                    // Cambiamos el fragmento list por el del detalle del jugador
                    transaction.replace(R.id.fragmentContainerView, DetailFragment.newInstance())
                    transaction.addToBackStack("volver")
                    transaction.commit()
                }
            }
        }
        // Asignacion de componentes
        val layoutManager = GridLayoutManager(this.context, 2)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adaptador

        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {
            }
    }
}