package controllers

object LoginForm {
    import play.api.data.Forms._
    import play.api.data.Form

    case class LoginData(email: String, password: String) {

        object LoginData{
            def unapply(l: LoginData): Option[(String, String)] = Some(l.email, l.password)
        }
    }

    val loginForm = Form(
        mapping(
            "email" -> email,
            "password" -> nonEmptyText
        )(LoginData.apply)(LoginData.unapply)
    )

    

}
