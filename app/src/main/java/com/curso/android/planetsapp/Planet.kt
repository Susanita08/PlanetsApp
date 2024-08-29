package com.curso.android.planetsapp

class Planet(planetName: String, moonCount: String, planetImage: Int) {
    private val _planetName: String = planetName
    private val _moonCount: String = moonCount
    private val _planetImage: Int = planetImage

    val planetName: String
        get() = _planetName

    val moonCount: String
        get() = _moonCount

    val planetImage: Int
        get() = _planetImage

}