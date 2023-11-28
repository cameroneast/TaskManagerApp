package controllers

import javax.inject._

import models.LoginInfo
import scala.jdk.CollectionConverters._
import play.api._
import play.api.mvc._
import play.api.data._
import models.Manager
import models.Task
import scala.collection.mutable.Map

import play.api.data.Forms._
import play.api.i18n._
import java.lang.ProcessBuilder.Redirect
import models.Person
import scala.collection.mutable.HashMap
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import scala.collection.mutable.ArrayBuffer


class AuthController@Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {
    import LoginForm._
    import RegisterForm._

    private val loginURL = routes.AuthController.loginComplete

    def loginEmpty() = Action {implicit request: MessagesRequest[AnyContent] => 
        
        Ok(views.html.login(loginForm, loginURL))
    
    }

    def registerEmpty = Action{implicit request: MessagesRequest[AnyContent] =>

        Ok(views.html.register(registerForm, loginURL))      
    }

    def registerComplete() = Action {implicit request: MessagesRequest[AnyContent] =>
        val errorFunction =  { (formWithErrors: Form[RegisterData]) => 
            
            BadRequest(views.html.register(formWithErrors, loginURL))
        }

        val sucessFunction = {(data: RegisterData) =>
            var apiKey = "AIzaSyDwNNjvA03CvvcFHDpTUrYKFBieekCfGI4"
            var firebase: Firebase = new Firebase("https://identitytoolkit.googleapis.com/v1/accounts:signUp");
            var  hash: HashMap[String, Any] = HashMap("email" -> data.email, "password" -> data.password, "returnSecureToken" -> "true")
            var js = hash.asJava
            firebase.addQuery("key", apiKey)
            var reponse = firebase.post( js)
            /*
            var hashRes = reponse.getBody().asScala 
            var person = new Person()
            var hash2: HashMap[String, Any] = HashMap("email" -> hashRes("email"), "userID" -> hashRes("localId"), "name" -> data.name, "type" -> "Person")
            var hash3: HashMap[String, Any] = HashMap(hashRes("idToken").toString -> hash2)
            var firebase2: Firebase = new Firebase("https://poised-kiln-273723-default-rtdb.firebaseio.com/")
            var js2 = hash2.asJava
            person.setName(data.name)
            person.setUserID(hashRes("email").toString)
            firebase.post(hashRes("localId").toString, js2)
            */
            
            
            Redirect(routes.AuthController.loginEmpty())
        }

        val formValidationResult = registerForm.bindFromRequest()
        formValidationResult.fold(errorFunction, sucessFunction)
        
    
    }

    def loginComplete = Action {implicit request: MessagesRequest[AnyContent] =>
        val errorFunction =  { (formWithErrors: Form[LoginData]) => 
            
            BadRequest(views.html.login(formWithErrors, loginURL))
        }

        val sucessFunction = {(data: LoginData) =>
            /*
            
            var apiKey = "AIzaSyDwNNjvA03CvvcFHDpTUrYKFBieekCfGI4"
            var firebase2: Firebase = new Firebase("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword")
            var hash: HashMap[String, Any] = HashMap("email" -> data.email, "password" -> data.password, "returnSecureToken" -> "true")
            var js = hash.asJava
            firebase2.addQuery("key", apiKey)
            
            var userRes = firebase2.post(js).getBody().asScala
            
            
            var firebase: Firebase = new Firebase("https://poised-kiln-273723-default-rtdb.firebaseio.com/")
            var response = firebase.get()
            var user2 = userRes("localId")
            var response2 = response.getBody()
            var responseScala: Map[String, Object] = response2.asScala
            var hashUser: Map[String, Object] = responseScala
            if(hashUser("type") == "Person") {
                var person: Person = new Person()   
                person.setName(hashUser("name").toString)
                person.setUserID(userRes("localId").toString)
                if(hashUser("manager") != null) {
                    person.setManager(hashUser("manager").toString)
                }
                var hashTasks: HashMap[String, Any] = hashUser("tasks")
                var task = new Task();
                var array = ArrayBuffer[Any]();
                if(hashTasks != null) {
                    for ((k, v) <- hashTasks) {
                        task = new Task()
                        array = v.asScala
                        task.setUserAssigned(array(0).toString)
                        task.setDescription(array(1).toString)
                        if(array(2).toString == "true") {
                            task.setisComplete = true
                        } else {
                            task.setisComplete = false
                        }
                        person.addTask(task)
                    }
                } 
                Redirect(routes.AuthController.loginComplete)

                
            }
            else {
                var manager = new Manager()
                var user = HashMap()
                manager.setName(hashUser("name").toString)
                manager.setUserID(hashUser("userID").toString)
                var hashEmploy = hashUser("people")
                var person = new Person()
                for ((k, v: String) <- hashEmploy) {
                    var user: HashMap[String, Any] 
                    user = response(v.toString)     
                    person.setName(user("name").toString)
                    person.setUserID(user("localId").toString)
                    if(hashUser("manager") != null) {
                        person.setManager(user("manager").toString )
                    }
                    var hashTasks: HashMap[String, Any] = user("tasks")
                    var task = new Task();
                    var array = ArrayBuffer[Any]();
                    if(hashTasks != null) {
                        for ((k, v) <- hashTasks) {
                            task = new Task()
                            array = v.toScala
                            task.setUserAssigned(array(0))
                            task.setDescription(array(1))
                            task.setisComplete(array(2))
                            person.addTask()
                        }
                    }
                    manager.addEmployee(person)

                }
                */
                Redirect(routes.AuthController.loginComplete())
            }
        }

        val formValidationResult = loginForm.bindFromRequest()
        formValidationResult.fold(errorFunction, sucessFunction)
        
    
    }
}
