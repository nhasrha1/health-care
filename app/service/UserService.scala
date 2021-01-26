package service

import database.dao.UserDao
import javax.inject.Inject
import models.{LoginRequest, User}

import scala.concurrent.{ExecutionContext, Future}

class UserService @Inject()(userDao: UserDao)(implicit
                                              ec: ExecutionContext) {

  def login(request: LoginRequest): Future[Option[User]] =
    userDao.userLogin(
      User(id = request.id, email = request.email, password = request.password)
    )
}
