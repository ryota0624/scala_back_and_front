package domain.Entity.Post

import domain.Entity.Post.Comment._
import domain.Entity.Topic.TopicId
import domain.Entity.share.EntityId

/**
  * Created by ryota on 2016/08/14.
  */
case class PostText(value: String)
case class PostId(value: Int)
case class CommentList(value: List[Comment])
class Post(val id: PostId,val text: PostText, var commentList: CommentList, val topicId: TopicId) {
  def addComment(comment: Comment): Unit = {
    commentList = CommentList.apply(comment::commentList.value)
  }
}

object Post {
  def apply(text: String, commentList: CommentList = CommentList(Nil), topicId: TopicId): Post =
    new Post(PostId(EntityId.create()), PostText(text), commentList, topicId)
}
