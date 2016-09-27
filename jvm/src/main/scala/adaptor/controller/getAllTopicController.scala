package adaptor.controller

import adaptor.presenter.json.AllTopicPresenterImplJson
import adaptor.repositoryImpl.onMemory.TopicRepositoryOnMemory
import akka.http.scaladsl.server.StandardRoute
import usecase.query.Topic.GetAllTopicUsecase

/**
  * Created by ryota on 2016/09/22.
  */
object getAllTopicController extends Controller {
  def call(): StandardRoute = {
    val repo = new TopicRepositoryOnMemory
    val usecase = new GetAllTopicUsecase(repo)
    val presenter = new AllTopicPresenterImplJson
    excute(usecase, Nil) match {
      case Some(list) => presenter.show(list)
      case None => presenter.fail(new Error("some Error"))
    }
  }
}
