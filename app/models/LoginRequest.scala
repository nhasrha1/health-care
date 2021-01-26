package models
import play.api.libs.json.{Format, Json}

case class LoginRequest(id: String, email: String, password: String)

object LoginRequest {
  // 1. Q&A
  implicit val format: Format[LoginRequest] = Json.format[LoginRequest]
}
