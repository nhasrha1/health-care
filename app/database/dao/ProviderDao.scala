package database.dao

import database.schema.DatabaseTables._
import javax.inject.Inject
import models.{Provider, ProviderServiceCost}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class ProviderDao @Inject()(
  @NamedDatabase("health_care") protected val dbConfigProvider: DatabaseConfigProvider,
  cc: ControllerComponents
)(implicit
  ec: ExecutionContext)
    extends AbstractController(cc)
    with HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  def searchProviders(searchText: String): Future[Seq[Provider]] = {
    val query = providersTable
      .filter(row => row.name.toLowerCase.like(s"%${searchText.toLowerCase}%"))
      .result
    db.run(query)
  }

  def getProviderById(providerId: String): Future[Seq[ProviderServiceCost]] = {
    val query = providerServicesTable
      .filter(row => row.providerId === providerId)
      .result
    db.run(query)
  }

  def getSelectedProviderDetails(id: String): Future[Seq[Provider]] = {
    val query = providersTable
      .filter(row => row.id === id)
      .result
    db.run(query)
  }

}
