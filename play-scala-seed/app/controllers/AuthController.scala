package controllers

import javax.inject._

import models.LoginInfo

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.i18n._



class AuthController@Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {
    import LoginForm._

    private val loginURL = routes.AuthController.loginComplete

    def loginEmpty = Action {implicit request: MessagesRequest[AnyContent] => 
        
        Ok(views.html.login(form, loginURL))
    
    }

    def loginComplete = Action {implicit request: MessagesRequest[AnyContent] =>
        
        
    
    }
}
