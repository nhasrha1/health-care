package database.schema

import java.sql.Timestamp

import models.Provider
import slick.jdbc.PostgresProfile.api._

class ProvidersTable(tag: Tag) extends Table[Provider](tag, "providers") {
  def id = column[String]("id", O.PrimaryKey)
  def name = column[String]("name")
  def company = column[String]("company")
  def address = column[String]("address")
  def phone = column[String]("phone")
  def createdAt = column[Timestamp]("created_at")

  def * =
    (id, name, company, address, phone, createdAt) <> ((Provider.apply _).tupled, Provider.unapply)
}
