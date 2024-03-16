class EmpleadoController (private val printer: Printer) {
    private val empleadoList = mutableListOf<Empleado>()

    fun registerEmpleado(){
        printer.printMsg("Nombre del empleado")
        val name = readln()
        printer.printMsg("Primer apellido del empleado")
        val firstLastName = readln()
        printer.printMsg("Segundo apellido del empleado")
        val secondLastName = readln()
        printer.printMsg("Puesto del empleado")
        val puesto = readln()
        printer.printMsg("Número de teléfono")
        val phoneNumber = readln().toInt()
        printer.printMsg("Número de nómina")
        val nomina = readln()
        printer.printMsg("Correo electrónico")
        val email = readln()
        val isAvailable = true

        val addedEmpleado =
            Empleado(name, firstLastName, secondLastName, puesto, phoneNumber, nomina, email, isAvailable)
        empleadoList.add(addedEmpleado)
    }

    fun modifyEmpleado(modifiedEmpleado: Empleado, index: Int) {
        if (index in empleadoList.indices) {
            empleadoList[index] = modifiedEmpleado
        } else {
            printer.printMsg("índice de empleado no válido")
        }
    }

    fun getEmpleadoByIndex(index: Int): Empleado? {
        return if (index in empleadoList.indices) {
            empleadoList[index]
        } else {
            printer.printMsg("Índice de habitación no válido")
            null
        }
    }

    fun showEmpleado(){
        if (empleadoList.isEmpty()) {
            printer.printMsg("No se encuentran empleados registrados")
        } else {
            var counter = 1
            for (empleado in empleadoList) {
                printer.printMsg("$counter" + empleado.getEmpleadoData())
                counter++
            }

        }
    }

    fun areNotEmpleadoRegistered(): Boolean = empleadoList.isEmpty()
}
