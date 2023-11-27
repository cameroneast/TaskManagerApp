package controllers

import javax.inject._

import models.LoginInfo
import scala.jdk.CollectionConverters._

import play.api._
import play.api.mvc._
import play.api.data._

import play.api.data.Forms._
import play.api.i18n._
import java.lang.ProcessBuilder.Redirect
import models.Person
import scala.collection.mutable.HashMap
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;



class AuthController@Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {
    import LoginForm._
    import RegisterForm._

    private val loginURL = routes.AuthController.loginComplete

    def loginEmpty = Action {implicit request: MessagesRequest[AnyContent] => 
        
        Ok(views.html.login(loginForm, loginURL))
    
    }

    def registerEmpty = Action{implicit request: MessagesRequest[AnyContent] =>

        Ok(views.html.register(registerForm, loginURL))      
    }

    def registerComplete = Action {implicit request: MessagesRequest[AnyContent] =>
        val errorFunction =  { (formWithErrors: Form[RegisterData]) => 
            
            BadRequest(views.html.register(formWithErrors, loginURL))
        }

        val sucessFunction = {(data: RegisterData) =>
            var apiKey = "AIzaSyDwNNjvA03CvvcFHDpTUrYKFBieekCfGI4"
            var firebase: Firebase = new Firebase("https://identitytoolkit.googleapis.com/v1/accounts:signUp");
            var  hash: HashMap[String, Any] = HashMap("email" -> data.email, "password" -> data.password, "returnSecureToken" -> "true")
            var js = hash.asJava
            firebase.addQuery("key", apiKey)
            var reponse = firebase.post("signupNewUser", js)
            var hashRes = reponse.getBody().asScala
            var person = new Person()
            var hash2: HashMap[String, Any] = HashMap("email" -> hashRes("email"), "userID" -> hashRes("idToken"), "name" -> data.name, "type" -> "Person")
            var hash3: HashMap[String, Any] = HashMap(hashRes("idToken").toString -> hash2)
            var js2 = hash3.asJava
            var firebase2: Firebase = new Firebase("https://poised-kiln-273723-default-rtdb.firebaseio.com/")
            firebase2.put(js2);            

            Redirect(routes.AuthController.loginComplete)
        }

        val formValidationResult = registerForm.bindFromRequest()
        formValidationResult.fold(errorFunction, sucessFunction)
        
    
    }

    def loginComplete = Action {implicit request: MessagesRequest[AnyContent] =>
        val errorFunction =  { (formWithErrors: Form[LoginData]) => 
            
            BadRequest(views.html.login(formWithErrors, loginURL))
        }

        val sucessFunction = {(data: LoginData) =>

            Redirect(routes.AuthController.loginComplete)
        }

        val formValidationResult = loginForm.bindFromRequest()
        formValidationResult.fold(errorFunction, sucessFunction)
        
    
    }
}
