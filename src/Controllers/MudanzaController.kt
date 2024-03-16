package Controllers

import Class.Mudanza
import Class.Printer

class MudanzaController (private val printer: Printer) {
    private val mudanzaList = mutableListOf<Mudanza>()

    fun registeredMudanza() {
        printer.printMsg("Precio por kg de mudanza")
        val peso = readln().toDouble()
        printer.printMsg("Distancia en km de la mudanza")
        val distance = readln().toDouble()
        printer.printMsg("¿Incluye seguro?")
        val seguro = false

        val addedMudanza = Mudanza(peso, distance, seguro)
        mudanzaList.add(addedMudanza)
    }
    fun getMudanzaByIndex(index: Int): Mudanza? {
        return if (index in mudanzaList.indices) {
            mudanzaList[index]
        } else {
            printer.printMsg("Índice de mudanza no válido")
            null
        }
    }
    fun showMudanza(){
        if (mudanzaList.isEmpty()) {
            printer.printMsg("No se encuentran mudanzas registradas")
        } else {
            var counter = 1
            for (mudanza in mudanzaList) {
                printer.printMsg("$counter" + mudanza.getMudanzaData())
                counter++
            }
        }
    }

    fun areNotEmpleadoRegistered(): Boolean = mudanzaList.isEmpty()
}