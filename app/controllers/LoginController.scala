package controllers

import models.LoginRequest
import service.UserService
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents, EssentialAction}

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class LoginController @Inject()(
  service: UserService,
  controllerComponents: ControllerComponents
)(implicit ec: ExecutionContext)
    extends AbstractController(controllerComponents) {

  // 2.Q&A
//  def login: EssentialAction =
//    Action.async(parse.json[LoginRequest])(
//      request => Future { Created(Json.toJson()) }
//    )

  def login: EssentialAction = Action.async(parse.json[LoginRequest]) {
    request =>
      service.login(request.body).map {
        case Some(admin) => Created(Json.toJson(admin))
        case _           => NotFound
      }
  }

}
