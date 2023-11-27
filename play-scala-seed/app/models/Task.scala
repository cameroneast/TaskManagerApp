class Task {
    // Class variables
    var UserAssigned: Person = null
    var Description: String = ""
    var Priority: Int = 0
    var isComplete: Boolean = false

    // Getters and Setters
    def getUserAssigned(): Person = {
        return UserAssigned
    }

    def setUserAssigned(UserAssigned: Person): Person = {
        this.UserAssigned = UserAssigned
    }

    
    def getDescription(): String = {
        return Description
    }

    def setDescription(Description: String): String = {
        this.Description = Description
    }


    def getPriority(): Int = {
        return Priority
    }

    def setPriority(Priority: Int): Int = {
        this.Priority = Priority
    }


    def getisComplete(): Boolean = {
        return isComplete
    }

    def setisComplete(isComplete: Boolean): Boolean = {
        this.isComplete = isComplete
    }
}
