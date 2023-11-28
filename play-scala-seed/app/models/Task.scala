package models
class Task {
    // Class variables
    var UserAssigned: String = null
    var Description: String = ""
    var Priority: Int = 0
    var isComplete: Boolean = false

    // Getters and Setters
    def getUserAssigned(): String = {
        return UserAssigned
    }

    def setUserAssigned(UserAssigned: String): Unit = {
        this.UserAssigned = UserAssigned
    }

    
    def getDescription(): String = {
        return Description
    }

    def setDescription(Description: String): Unit = {
        this.Description = Description
    }


    def getPriority(): Int = {
        return Priority
    }

    def setPriority(Priority: Int): Unit = {
        this.Priority = Priority
    }


    def getisComplete(): Boolean = {
        return isComplete
    }

    def setisComplete(isComplete: Boolean): Unit = {
        this.isComplete = isComplete
    }
}
