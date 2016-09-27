package adaptor.presenter.json

import adaptor.Dtos.TopicDto
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.{Directives, StandardRoute}
import spray.json._
import usecase.adaptor.Presenter.AllTopicPresenter

/**
  * Created by ryota on 2016/08/14.
  */
case class TopicListDtos(topics: List[TopicDto])
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val topicFormat = jsonFormat1(TopicDto)
  implicit val topicsFormat = jsonFormat1(TopicListDtos)
}

class AllTopicPresenterImplJson
  extends AllTopicPresenter
    with Directives
    with PresenterTrait
    with JsonSupport {
  def show(list: List[TopicDto]): StandardRoute = complete(list)
  def fail(err: Error): StandardRoute = super.failWith(err)
}
