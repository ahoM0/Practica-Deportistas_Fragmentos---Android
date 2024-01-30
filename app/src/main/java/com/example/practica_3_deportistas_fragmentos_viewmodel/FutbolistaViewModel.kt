package com.example.practica_3_deportistas_fragmentos_viewmodel

import androidx.lifecycle.ViewModel

class FutbolistaViewModel : ViewModel() {
    // Variable privada de listado de futbolistas
    private var _futbolistas : MutableList<Futbolista>
    private var _elegido : Futbolista?=null

    // Variable futbolistas que devuelve la lista de futbolistas
    val futbolistas : List<Futbolista>
        get() = _futbolistas.toList()
    // Variable para el futbolista elegido
    var elegido : Futbolista?
        get() = _elegido
        set(item){_elegido=item}

    init {
        this._futbolistas = mutableListOf()
        this._futbolistas.add(
            Futbolista(
                "Cristiano Ronaldo",
                38,
                "Delantero",
                355,
                "Máximo Goleador de todos los tiempos."
            ))
        this._futbolistas.add(
            Futbolista(
                "Leo Messi",
                36,
                "Delantero",
                400,
                "Jugador mas completo de todos los tiempos."
            )
        )
        this._futbolistas.add(
            Futbolista(
                "Sergio Ramos",
                30,
                "Defensa",
                254,
                "El mejor defensa de españa."
            )
        )
    }

}