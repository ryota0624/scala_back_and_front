package adaptor.presenter.json

import adaptor.API.JsonSupport
import adaptor.Dtos.TopicDto
import akka.http.scaladsl.server.{Directives, StandardRoute}
import usecase.adaptor.Presenter.AllTopicPresenter

/**
  * Created by ryota on 2016/08/14.
  */
case class TopicListDtos(topics: List[TopicDto])

class AllTopicPresenterImplJson
  extends AllTopicPresenter
    with Directives
    with PresenterTrait
    with JsonSupport {
  def show(list: List[TopicDto]): StandardRoute = complete(list)
}
