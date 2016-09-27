package domain.Repository

import domain.Entity.Post._
import domain.Entity.Topic.TopicId

/**
  * Created by ryota on 2016/08/14.
  */
trait PostRepository {
  def findPostById(id: PostId): Option[Post]
  def findPostListByTopicId(id: TopicId): Option[List[Post]]
  def store(post: Post): Option[Unit]
  def update(post: Post): Option[Unit]
}
