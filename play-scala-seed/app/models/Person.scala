class Person {
    // Class variables
    var UserID: String = ""
    var Name: String = ""
    var Manager: Manager = null
    // ArrayList of Task objects
    var Tasks: ArrayList[Task] = new ArrayList[Task]()

    // Getters and Setters
    def getUserID(): String = {
        return UserID
    }

    def setUserID(UserID: String) {
        this.UserID = UserID
    }


    def getName(): String = {
        return Name
    }

    def setName(Name: String) {
        this.Name = Name
    }


    def getTasks(): ArrayList[Task] = {
        return this.Tasks
    }

    def addTask(Task: Task) {
        this.Tasks.add(Task)
    }

    def removeTask(Task: Task) {
        this.Tasks.remove(Task)
    }

    def removeTask(TaskIndex: Int) {
        this.Tasks.remove(TaskIndex)
    }

    def getTask(TaskIndex: Int): Task = {
        return this.Tasks.get(TaskIndex)
    }

    def getTask(Task: Task): Task = {
        return this.Tasks.get(this.Tasks.indexOf(Task))
    }


    def getManager(): Manager = {
        return this.Manager
    }

    def setManager(Manager: Manager) {
        this.Manager = Manager
    }
}
