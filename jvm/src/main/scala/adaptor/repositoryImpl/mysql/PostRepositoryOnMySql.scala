package adaptor.repositoryImpl.mysql

import domain.Entity.Post.{Post, PostId}

/**
  * Created by ryota on 2016/08/20.
  */
//class PostRepositoryOnMySql extends PostRepository {
////  override def findPostById(id: PostId): Option[Post] = {
//////    PostRepositoryOnMySql.store
////  }
//}

object PostRepositoryOnMySql {
  var store: Map[PostId, Post] = Map()
}