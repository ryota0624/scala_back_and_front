package adaptor.controller

import adaptor.presenter.json.RegisterTopicPresenterImplJson
import adaptor.repositoryImpl.onMemory.TopicRepositoryOnMemory
import akka.http.scaladsl.server.StandardRoute
import akka.http.scaladsl.server.directives.MarshallingDirectives
import usecase.command.Topic.RegisterTopicUseCase

/**
  * Created by ryota on 2016/09/28.
  */
case class TopicNameRequest(name: String)

object registerTopicController
  extends Controller
    with MarshallingDirectives {
  def call(request: TopicNameRequest): StandardRoute = {
    val repo = new TopicRepositoryOnMemory
    val usecase = new RegisterTopicUseCase(repo)
    val presenter = new RegisterTopicPresenterImplJson

    excute(usecase, request.name) match {
      case Some(topic) => presenter.show(topic) //presenter.show(list)
      case None => presenter.fail(new Error("some Error"))
    }
  }
}
