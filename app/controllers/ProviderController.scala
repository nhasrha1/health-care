package controllers

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents, EssentialAction}
import service.ProviderService

import scala.concurrent.ExecutionContext

class ProviderController @Inject()(service: ProviderService,
                                   controllerComponents: ControllerComponents)(
  implicit
  ec: ExecutionContext
) extends AbstractController(controllerComponents) {

  def searchProviders(searchText: String): EssentialAction = Action.async {
    service
      .searchProviders(searchText)
      .map(providers => Ok(Json.toJson(providers)))
  }

  def getProviderById(providerId: String): EssentialAction = Action.async {
    service
      .getProviderById(providerId)
      .map(services => Ok(Json.toJson(services)))
  }

}
