package adaptor.repositoryImpl.onMemory

import domain.Entity.Post.{Post, PostId}
import domain.Entity.Topic.TopicId
import domain.Repository.PostRepository

/**
  * Created by ryota on 2016/08/20.
  */
class PostRepositoryOnMemory extends PostRepository {
  override def findPostById(id: PostId): Option[Post] = {
    PostRepositoryOnMemory.getById(id)
  }

  override def findPostListByTopicId(id: TopicId): Option[List[Post]]  = {
    val topicList = PostRepositoryOnMemory.store
      .map({ case(topicId, topic) => topic})
      .filter({ post => post.topicId == id})
    Some(topicList.toList)
  }

  override def update(post: Post): Option[Unit] = {
    PostRepositoryOnMemory.set(post)
    Some(Unit)
  }

  override def store(post: Post): Option[Unit] = {
    PostRepositoryOnMemory.set(post)
    Some(Unit)
  }
}

object PostRepositoryOnMemory {
  var store: Map[PostId, Post] = Map()
  def set(post: Post): Unit = {
    store = store.updated(post.id, post)
  }

  def getById(postId: PostId): Option[Post] = {
    store.get(postId)
  }
}

trait UsesPostRepository {
  val postRepository: PostRepository = new PostRepositoryOnMemory
}