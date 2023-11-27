// Inherit Person class
class Manager extends Person{
    // Class variables
    var Employees: ArrayList[Person] = new ArrayList[Person]()

    // Getters and Setters
    def getEmployees(): ArrayList[Person] = {
        return this.Employees
    }

    def addEmployee(Employee: Person): Person = {
        this.Employees.add(Employee)
    }

    def removeEmployee(Employee: Person): Person = {
        this.Employees.remove(Employee)
    }

    def removeEmployee(EmployeeIndex: Int): Int = {
        this.Employees.remove(EmployeeIndex)
    }

    def getEmployee(EmployeeIndex: Int): Person = {
        return this.Employees.get(EmployeeIndex)
    }

    def getEmployee(Employee: Person): Person = {
        return this.Employees.get(this.Employees.indexOf(Employee))
    }
}