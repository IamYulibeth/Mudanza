package Controllers

import Class.Cliente
import Class.Empleado
import Class.Mudanza
import Class.Printer
import Class.Solicitudes

class SolicitudesController (private val printer: Printer) {

    private val solicitudesList = mutableListOf<Solicitudes>()

    fun createSolicitud(cliente: Cliente, empleado: Empleado, mudanza : Mudanza){
        printer.printMsg("Fecha:")
        val date = readln()
        printer.printMsg("Hora asiganada")
        val hora = readln()
        printer.printMsg("Detalles de la mudanza")
        val details = readln()
        printer.printMsg("Dirección:")
        val address = readln()
        printer.printMsg("Peso total de la mudanza:")
        val totalPeso = readln().toDouble()
        printer.printMsg("Distancia de la mudanza en km")
        val totalDistance = readln().toDoubleOrNull() ?: 0.0
        printer.printMsg("Persona que registro la solicitud") //Class.Empleado que creo la solicitud de mudanza
        val nameRegistrador = readln()

        val addedSolicitudes = Solicitudes(
            cliente, empleado, mudanza, date, hora, details, address, totalPeso, totalDistance, nameRegistrador
        )

        addedSolicitudes.calcularTotal()
        cliente.addSolicitudes(addedSolicitudes)
        solicitudesList.add(addedSolicitudes)
    }

    fun showSolicitudes(){
        if (solicitudesList.isEmpty()){
            printer.printMsg("No hay solicitudes añadidas")
        } else {
            var counter = 1
            for (solicitudes in solicitudesList) {
                printer.printMsg("$counter" + solicitudes.getSolicitudesData())
                counter++
            }

        }
    }
}