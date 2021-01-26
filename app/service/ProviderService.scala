package service

import database.dao.ProviderDao
import javax.inject.Inject
import models.{Provider, ProviderServiceCost}

import scala.concurrent.{ExecutionContext, Future}

class ProviderService @Inject()(providerDao: ProviderDao)(
  implicit
  ec: ExecutionContext
) {

  def searchProviders(searchText: String): Future[Seq[Provider]] =
    providerDao.searchProviders(searchText)

  def getProviderById(providerId: String): Future[Seq[ProviderServiceCost]] =
    providerDao.getProviderById(providerId)

  def getSelectedProviderDetails(id: String): Future[Seq[Provider]] =
    providerDao.getSelectedProviderDetails(id)

}
