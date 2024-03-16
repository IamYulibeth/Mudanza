class Empleado(
    val name: String,
    val firstLastName: String,
    val secondLastName: String,
    val puesto: String,
    val phoneNumber: Int,
    val nomina: String,
    val email: String,
    val disponibility: Boolean,
    val isAvailable: Boolean = true

) {
    fun getEmpleadoData(): String {
        return "Nombre $name $firstLastName $secondLastName"
        "Puesto: $puesto"
        "Número de Teléfono: $phoneNumber"
        "Número de nómina: $nomina"
        "Correo Electrónico: $email"
        "Disponibilidad: $disponibility ${if (isAvailable) "Sí" else "No"}"
    }
}