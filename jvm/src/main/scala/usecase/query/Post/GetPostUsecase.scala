package usecase.query.Post

import domain.Entity.Post.{Post, PostId}
import domain.Repository.PostRepository
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/20.
  */
class GetPostUsecase(postRepository: PostRepository)
  extends Usecase[GetPostUsecase.Input, GetPostUsecase.Output]{
  def call(postId: GetPostUsecase.Input): GetPostUsecase.Output = {
    postRepository.findPostById(PostId(postId))
  }
}

object GetPostUsecase {
  type Input = Int
  type Output = Option[Post]
}