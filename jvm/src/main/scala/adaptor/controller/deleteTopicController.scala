package adaptor.controller

import adaptor.presenter.json.DeleteTopicPresenterImplJson
import adaptor.repositoryImpl.onMemory.TopicRepositoryOnMemory
import akka.http.scaladsl.server.StandardRoute
import akka.http.scaladsl.server.directives.MarshallingDirectives
import usecase.command.Topic.DeleteTopicUsecase

/**
  * Created by ryota on 2016/09/28.
  */
case class TopicIdRequest(id: Int)

object deleteTopicController extends Controller with MarshallingDirectives {
  def call(request: TopicIdRequest): StandardRoute = {
    val repo = new TopicRepositoryOnMemory
    val usecase = new DeleteTopicUsecase(repo)
    val presenter = new DeleteTopicPresenterImplJson

    excute(usecase, request.id) match {
      case Some(topicDto) => presenter.show(topicDto)
      case None => presenter.fail(new Error("some Error"))
    }
  }
}
