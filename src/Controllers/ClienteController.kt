package Controllers

import Class.Cliente
import Class.Printer

class ClienteController (private val printer: Printer){

    private val clientList: MutableList<Cliente> = mutableListOf()

    fun registerCliente() {
        println("Ingresa el nombre del cliente")
        val name = readln()
        println("¿Cuál es su primer apellido?")
        val firstLastName = readln()
        println("¿Cuál es su segundo apellido?")
        val secondLastName = readln()
        println("¿Cuál es su dorección?")
        val address = readln()
        println("¿Cuál es su RFC?")
        val rfc = readln()
        println("¿Cuál es su número de teléfono?")
        val phoneNumber = readln().toInt()
        println("¿Cuál es su correo electrónico?")
        val email = readln()

        val addedCliente = Cliente(name, firstLastName, secondLastName, address, rfc, phoneNumber, email)
        clientList.add(addedCliente)
    }

    fun showCliente(){
        if (clientList.isEmpty()) {
            printer.printMsg("No se encuentran clientes registrados")
        } else {
            var counter = 1
            for (cliente in clientList) {
                printer.printMsg("$cliente" + cliente.getClienteData())
                counter++
            }
        }
    }

    fun loadClientsFromDB(){
    }

    fun getClienteByIndex(index: Int): Cliente = clientList[index]

    fun areNotClientRegistered(): Boolean = clientList.isEmpty()
}