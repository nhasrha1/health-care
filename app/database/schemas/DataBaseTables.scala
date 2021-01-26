package database.schema

import slick.lifted.{AbstractTable, Rep, TableQuery}

trait DBSortFields[T] extends AbstractTable[T] {
  def sortFields: Map[String, Rep[_]]
}

object DatabaseTables {
  lazy val usersTable = TableQuery[UsersTable]
  lazy val providersTable = TableQuery[ProvidersTable]
  lazy val providerServicesTable = TableQuery[ProviderServicesTable]
}
