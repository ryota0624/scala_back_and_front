package domain.Entity.Post.Comment

import domain.Entity.Post.PostId
import domain.Entity.share.EntityId

/**
  * Created by ryota on 2016/08/14.
  */
case class CommentId(value: Int)

case class Text(value: String)

class Comment(val id: CommentId, val text: Text, val postId: PostId) {

}

object Comment {
  def apply(text: String, postId: PostId): Comment = new Comment(CommentId(EntityId.create()), Text(text), postId)
}
