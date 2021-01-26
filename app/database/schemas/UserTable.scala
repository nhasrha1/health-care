package database.schema

import java.sql.Timestamp

import models.User
import slick.jdbc.PostgresProfile.api._

class UsersTable(tag: Tag) extends Table[User](tag, "users") {
  def id = column[String]("id", O.PrimaryKey)
  def email = column[String]("email")
  def password = column[String]("password")
  def createdAt = column[Timestamp]("created_at")

  def * =
    (id, email, password, createdAt) <> ((User.apply _).tupled, User.unapply)
}
