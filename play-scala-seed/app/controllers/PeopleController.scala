package controllers

import javax.inject._

import models.{LoginInfo, Person, Manager} // Import other necessary model classes

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n._
import scala.util.Using.Manager

class PeopleController@Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {

    def showTasks(userID: String) = Action { implicit request: MessagesRequest[AnyContent] => 

        Ok(views.html.person(person))

    }

    def showPeople(userID: String) = Action { implicit request: MessagesRequest[AnyContent] => 

        Ok(views.html.manager(manager))

    }

}