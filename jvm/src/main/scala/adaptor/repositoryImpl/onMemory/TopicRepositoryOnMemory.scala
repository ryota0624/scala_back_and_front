package adaptor.repositoryImpl.onMemory

import domain.Entity.Topic.{Topic, TopicId}
import domain.Repository.TopicRepository
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Created by ryota on 2016/08/14.
  */
class TopicRepositoryOnMemory extends TopicRepository {
  def store(topic: Topic): Future[Unit] = Future {
    TopicRepositoryOnMemory.set(topic)
  }

  def remove(topic: Topic): Option[Unit] = {
    TopicRepositoryOnMemory.remove(topic)
    Some(Unit)
  }
  override def update(topic: Topic): Option[Unit] = {
    TopicRepositoryOnMemory.set(topic)
    Some(Unit)
  }

  override def findTopicId(id: TopicId): Option[Topic] = {
    TopicRepositoryOnMemory.getById(id)
  }
  override def findAll(): Option[List[Topic]] = {
    val topics = TopicRepositoryOnMemory.store.map{ case (_, topic)=> topic }.toList
    Some(topics)
  }
}

object TopicRepositoryOnMemory {
  var store: Map[TopicId, Topic] = Map()
  def set(topic: Topic): Unit = {
    store = store.updated(topic.id, topic)
  }

  def remove(topic: Topic): Unit = {
    store = store - topic.id
  }

  def getById(topicId: TopicId): Option[Topic] = {
    store.get(topicId)
  }
}

trait UsesTopicRepository {
  val topicRepository: TopicRepository = new TopicRepositoryOnMemory
}