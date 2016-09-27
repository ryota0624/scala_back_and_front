package domain.Entity.Topic

import domain.Entity.Post.{Post, PostId}
import domain.Entity.share.EntityId

/**
  * Created by ryota on 2016/08/14.
  */
case class TopicId(value: Int)

case class Name(value: String)

case class PostIds(value: List[PostId])

class Topic(val id: TopicId, val name: Name, var postIds: PostIds) {
  def addPost(post: Post): Unit = {
    postIds = PostIds(post.id::postIds.value)
  }
}

object Topic {
  def apply(name: String, postIds: PostIds = PostIds(Nil)): Topic = new Topic(TopicId(EntityId.create()), Name(name), postIds)
}