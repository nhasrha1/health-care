package models

import java.sql.Timestamp
import java.util.Date

import formatters.TimestampFormatter
import play.api.libs.json._

case class User(id: String,
                email: String,
                password: String,
                createdAt: Timestamp = new Timestamp((new Date()).getTime()))

// 3.Q&A
object User extends TimestampFormatter {
  implicit val userFormat = Json.format[User]
}
