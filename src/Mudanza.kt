class Mudanza (
    val peso: Double, //Valor por kg de la mudanza
    val distance: Double,
    val seguro: Boolean,

) { fun getMudanzaData(): String{
    return "Peso de la mudanza $peso Distancia en km: $distance ¿Incluyó seguro de mudanza? $seguro"
}

}