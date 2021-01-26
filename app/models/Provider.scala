package models

import java.sql.Timestamp
import java.util.Date

import formatters.TimestampFormatter
import play.api.libs.json.Json

case class Provider(
  id: String,
  name: String,
  company: String,
  address: String,
  phone: String,
  createdAt: Timestamp = new Timestamp((new Date()).getTime())
)

object Provider extends TimestampFormatter {
  implicit val providerFormat = Json.format[Provider]
}
