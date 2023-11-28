package models
import scala.collection.mutable.ArrayBuffer

import play.api.mvc.QueryStringBindable
import scala.collection.mutable.ArrayBuffer

class Person() {

    // Constructor
    def this(userID: String, name: String, manager: Manager, tasks: ArrayBuffer[Task]) = {
        this()
        this.userID = userID
        this.name = name
        this.manager = manager
        this.tasks = tasks
    }
    
    // Class variables
    var userID: String = ""
    var name: String = ""
    var manager: Manager = null
    // ArrayList of Task objects
    var tasks: ArrayBuffer[Task] = new ArrayBuffer[Task]()

    // Getters and Setters
    def getUserID(): String = {
        return userID
    }

    def setUserID(userID: String): Unit = {
        this.userID = userID
    }


    def getName(): String = {
        return name
    }

    def setName(name: String): Unit = {
        this.name = name
    }


    def getTasks(): ArrayBuffer[Task] = {
        return this.tasks
    }

    def addTask(task: Task): Unit = {
        this.tasks.append(task)
    }

    def removeTask(task: Task): Unit = {
        this.tasks -= task
    }

    def removeTask(taskIndex: Int): Unit = {
        this.tasks -= this.tasks(taskIndex)
    }

    def getTask(taskIndex: Int): Task = {
        return this.tasks(taskIndex)
    }

    def getTask(task: Task): Task = {
        return this.tasks(this.tasks.indexOf(task))
    }


    def getManager(): Manager = {
        return this.manager
    }

    def setManager(manager: Manager): Unit = {
        this.manager = manager
    }
}
