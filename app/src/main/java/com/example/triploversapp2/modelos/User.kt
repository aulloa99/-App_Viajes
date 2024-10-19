package com.example.triploversapp2.modelos

class Usuario {
    var nombre: String? = null
    var intereses: String? = null
    var experienciaDeViaje: String? = null
    var ofreceServicios: Boolean = false
    var tipoDeServicio: String? = null
    var costoDelServicio: Double? = null
    var ubicacion: String? = null
    var calificacion: Float? = null
    var resenas: List<String>? = null
    var estaDisponible: Boolean = true


    constructor()


    constructor(
        nombre: String?,
        intereses: String?,
        experienciaDeViaje: String?,
        ofreceServicios: Boolean,
        tipoDeServicio: String?,
        costoDelServicio: Double?,
        ubicacion: String?,
        calificacion: Float?,
        resenas: List<String>?,
        estaDisponible: Boolean
    ) {
        this.nombre = nombre
        this.intereses = intereses
        this.experienciaDeViaje = experienciaDeViaje
        this.ofreceServicios = ofreceServicios
        this.tipoDeServicio = tipoDeServicio
        this.costoDelServicio = costoDelServicio
        this.ubicacion = ubicacion
        this.calificacion = calificacion
        this.resenas = resenas
        this.estaDisponible = estaDisponible
    }
}
