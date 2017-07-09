package adaptor.API

import domain.Entity.Topic.{Topic, TopicId}
import domain.Repository.TopicRepository
import fr.hmil.roshttp.HttpRequest
import fr.hmil.roshttp.Protocol.HTTP
import fr.hmil.roshttp.body.Implicits._
import fr.hmil.roshttp.body.JSONBody.JSONObject
import monix.execution.Scheduler.Implicits.global

import scala.concurrent.Future


/**
  * Created by ryota on 2016/11/20.
  */
class TopicRepositoryOnMemoryClient extends TopicRepository {
  override def findTopicId(id: TopicId): Option[Topic] = {
    None
  }

  override def findAll(): Option[List[Topic]] = {
    HttpRequest()
      .withProtocol(HTTP)
      .withHost("localhost")
      .withPort(9000)
      .withPath("/topic")
      .send().foreach((res) => println(res.body))

//    val str = Await.result(request, Duration.Inf).body
//    println(str)
    None
  }
  override def update(topic: Topic): Option[Unit] = None

  override def remove(topic: Topic): Option[Unit] = None

  override def store(topic: Topic): Future[Unit] = {
    val jsonDate = JSONObject(
      "name" -> topic.name.value
    )

    HttpRequest()
      .withProtocol(HTTP)
      .withHost("localhost")
      .withPort(9000)
      .withPath("/topic")
      .post(jsonDate).map[Unit](_ -> Unit)
  }
}
object TopicRepositoryOnMemoryClient {
  def apply() = new TopicRepositoryOnMemoryClient
}