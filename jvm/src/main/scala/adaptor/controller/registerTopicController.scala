package adaptor.controller

import adaptor.presenter.json.RegisterTopicPresenterImplJson
import adaptor.repositoryImpl.onMemory.TopicRepositoryOnMemory
import akka.http.scaladsl.server.StandardRoute
import akka.http.scaladsl.server.directives.MarshallingDirectives
import usecase.command.Topic.RegisterTopicUseCase

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration.Duration

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

    val result = excute(usecase, request.name).map(res => presenter.show(res))
    Await.result(result, Duration.Inf).asInstanceOf[StandardRoute]

  }
}
