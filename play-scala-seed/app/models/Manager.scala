// Inherit Person class
package models
import scala.collection.mutable.ArrayBuffer
class Manager extends Person{
    // Class variables
    var employees: ArrayBuffer[Person] = new ArrayBuffer[Person]()
    var people: ArrayBuffer[String] = new ArrayBuffer[String]()
    // Getters and Setters
    def getEmployees(): ArrayBuffer[Person] = {
        return this.employees
    }

    def setPeople(people: ArrayBuffer[String]): Unit = {
        this.people = people
    }

    def getPeople(): ArrayBuffer[String] = {
        return people
    }

    def addEmployee(employee: Person): Unit = {
        this.employees.append(employee)
    }

    def removeEmployee(employee: Person): Unit = {
        this.employees -= employee
    }

    def removeEmployee(employeeIndex: Int): Unit = {
        this.employees.remove(employeeIndex)    
    }

    def getEmployee(employeeIndex: Int): Person = {
        return this.employees(employeeIndex)
    }

    def getEmployee(employee: Person): Person = {
        return this.employees(this.employees.indexOf(employee))
    }
}