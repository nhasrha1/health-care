package models

import java.sql.Timestamp
import java.util.Date

import formatters.TimestampFormatter
import play.api.libs.json.Json

case class ProviderServiceCost(id: String,
                               providerId: String,
                               providerName: String,
                               serviceName: String,
                               costNear: String,
                               estimatedTotalCost: String,
                               insurancePays: String,
                               estimatedOutOfPocketCost: String,
                               createdAt: Timestamp = new Timestamp(
                                 (new Date()).getTime()
                               ))

object ProviderServiceCost extends TimestampFormatter {
  implicit val providerServiceCostFormat = Json.format[ProviderServiceCost]
}
