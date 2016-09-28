package adaptor.presenter.json

import adaptor.API.JsonSupport
import adaptor.Dtos.TopicDto
import akka.http.scaladsl.server.{Directives, StandardRoute}
import usecase.adaptor.Presenter.DeleteTopicPresenter

/**
  * Created by ryota on 2016/09/28.
  */
class DeleteTopicPresenterImplJson
  extends DeleteTopicPresenter
    with Directives
    with PresenterTrait
    with JsonSupport {
  def show(topic: TopicDto): StandardRoute = complete(topic)
}
