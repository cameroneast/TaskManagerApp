package controllers

object RegisterForm {
    import play.api.data.Forms._
    import play.api.data.Form

    case class RegisterData(email: String, password: String, name: String) {

        object RegisterData{
            def unapply(l: RegisterData): Option[(String, String, String)] = Some(l.email, l.password, l.name)
        }
    }

    val registerForm = Form(
        mapping(
            "email" -> email,
            "password" -> nonEmptyText,
            "name" -> nonEmptyText
        )(RegisterData.apply)(RegisterData.unapply)
    )

    

}
