package Controllers

import Class.Printer

class MenuController {
    private val printer = Printer()
    private val clienteController = ClienteController(printer)
    private val empleadoController = EmpleadoController(printer)
    private val solicitudesController = SolicitudesController(printer)
    private val mudanzaController = MudanzaController(printer)

    fun showMenu() {
        printer.apply {
            printMsg("Ingrese una opción")
            printMsg("1.- Registrar Class.Cliente.")
            printMsg("2.-Registrar Class.Empleado.")
            printMsg("3.- Crear una solicitud de mudanza.")
            printMsg("4.- Mostrar Clientes.")
            printMsg("5.- Mostrar Empleados.")
            printMsg("6.- Mostrar Class.Solicitudes de Class.Mudanza.")

            val selectedOption = readln().toInt()
            validateOptions(selectedOption)
        }
    }

    private fun validateOptions(selectedOption: Int) {
        when (selectedOption) {
            1 -> {
                clienteController.registerCliente()
                println("")
                showMenu()
            }

            2 -> {
                empleadoController.registerEmpleado()
                println("")
                showMenu()
            }

            3 -> {
                selectedClienteandEmpleadoandMudanza()
                println("")
                showMenu()
            }

            4 -> {
                clienteController.showCliente()
                println("")
                showMenu()
            }

            5 -> {
                empleadoController.showEmpleado()
                println("")
                showMenu()
            }

            6 -> {
                solicitudesController.showSolicitudes()
                println("")
                showMenu()
            }
        }
    }

    private fun selectedClienteandEmpleadoandMudanza() {
        if (clienteController.areNotClientRegistered()) {
            printer.printMsg("No se encuentran clientes registrados.")
            showMenu()
            return
        }
        if (empleadoController.areNotEmpleadoRegistered()) {
            printer.printMsg("No se encunetran empleados registrados.")
            showMenu()
            return
        }
        if (mudanzaController.areNotEmpleadoRegistered()) {
            printer.printMsg("No se encuentran mudanzas registradas.")
            showMenu()
            return
        }

        printer.printMsg("Selecciona un cliente")
        clienteController.showCliente()
        val selectedClienteIndex = readln().toInt()
        val cliente = clienteController.getClienteByIndex(selectedClienteIndex - 1)

        printer.printMsg("Selecciona una mudanza")
        mudanzaController.showMudanza()
        val selectedMudanzaIndex = readln().toInt()
        val mudanza = mudanzaController.getMudanzaByIndex(selectedMudanzaIndex -1)

        printer.printMsg("Selecciona un empleado")
        empleadoController.showEmpleado()
        val selectedEmpleadoIndex = readln().toInt()
        val empleado = empleadoController.getEmpleadoByIndex(selectedEmpleadoIndex - 1)

        empleado?.let {
            solicitudesController.createSolicitud(cliente, it, mudanza!!)
        } ?: { showMenu() }

    }
}
