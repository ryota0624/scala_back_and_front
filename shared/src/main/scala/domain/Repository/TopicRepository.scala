package domain.Repository

import domain.Entity.Topic._

import scala.concurrent.Future

/**
  * Created by ryota on 2016/08/14.
  */
trait TopicRepository {
  def findTopicId(id: TopicId): Option[Topic]
  def findAll(): Option[List[Topic]]
  def store(topic: Topic): Future[Unit]
  def update(topic: Topic): Option[Unit]
  def remove(topic: Topic): Option[Unit]
}
