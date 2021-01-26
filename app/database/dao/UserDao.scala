package database.dao

import database.schema.DatabaseTables._
import javax.inject.Inject
import models.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class UserDao @Inject()(
  @NamedDatabase("health_care") protected val dbConfigProvider: DatabaseConfigProvider,
  cc: ControllerComponents
)(implicit
  ec: ExecutionContext)
    extends AbstractController(cc)
    with HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  def getUserById(id: String): Future[Option[User]] = {
    val query = usersTable
      .filter(row => row.id === id)
      .result
      .headOption
    db.run(query)
  }

  def userLogin(user: User): Future[Option[User]] =
    getUserById(user.id).flatMap {
      case Some(_) => Future.successful(Some(user))
      case None => {
        println("*************")
        db.run(usersTable += user).map(_ => Some(user))
      }
    }
}
