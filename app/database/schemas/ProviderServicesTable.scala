package database.schema

import java.sql.Timestamp

import database.schema.DatabaseTables.providersTable
import models.ProviderServiceCost
import slick.jdbc.PostgresProfile.api._

class ProviderServicesTable(tag: Tag)
    extends Table[ProviderServiceCost](tag, "provider_services") {
  def id = column[String]("id", O.PrimaryKey)
  def providerId = column[String]("provider_id")
  def providerName = column[String]("provider_name")
  def serviceName = column[String]("service_name")
  def costNear = column[String]("cost_near")
  def estimatedTotalCost = column[String]("estimated_total_cost")
  def insurancePays = column[String]("insurance_pays")
  def estimatedOutOfPocketCost = column[String]("estimated_out_of_pocket_cost")
  def createdAt = column[Timestamp]("created_at")

  def providerFk =
    foreignKey("provider", providerId, providersTable)(
      _.id,
      onDelete = ForeignKeyAction.Cascade
    )

  def * =
    (
      id,
      providerId,
      providerName,
      serviceName,
      costNear,
      estimatedTotalCost,
      insurancePays,
      estimatedOutOfPocketCost,
      createdAt
    ) <> ((ProviderServiceCost.apply _).tupled, ProviderServiceCost.unapply)
}
