package com.example.practica_3_deportistas_fragmentos_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager


class HomeFragment : Fragment() {
    private lateinit var vista :View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_home, container, false)
        vista.findViewById<ImageView>(R.id.icono_home).setOnClickListener(){
            val fm: FragmentManager = parentFragmentManager
            val transaction = fm.beginTransaction()
            // Cambiamos el fragmento home por el de la lista de deportistas
            transaction.replace(R.id.fragmentContainerView, ListFragment.newInstance())
            transaction.addToBackStack("replacement")
            transaction.commit()
        }
        return vista
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
            }
    }
}

