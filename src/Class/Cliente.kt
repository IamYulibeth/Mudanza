package Class

class Cliente (
    val name: String,
    val firstLastName: String,
    val secondLastName: String,
    val address: String,
    val rfc: String,
    val phoneNumber: Int,
    val email: String,
) {
    fun getClienteData(): String{
        return "Nombre: $name $firstLastName $secondLastName, Dirección: $address, RFC: $rfc, Número de teléfono: $phoneNumber, Correo electrónico $email"
    }

    fun addSolicitudes(solicitudes: Solicitudes) {

    }

}