package usecase.command.Comment

import domain.Entity.Post.Comment.Comment
import domain.Entity.Post.{Post, PostId}
import domain.Repository.PostRepository
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */

trait RegisterCommentUsecase
  extends Usecase[RegisterCommentUsecase.Input, RegisterCommentUsecase.Output] {
  val postRepository: PostRepository
  def call(input: RegisterCommentUsecase.Input): RegisterCommentUsecase.Output = {
    input match {
      case (postId: Int, commentStr: String) => postRepository.findPostById(PostId(postId))
        .map(post => {
          post.addComment(Comment(commentStr, post.id))
          postRepository.update(post)
          post
        })
    }
  }
}

object RegisterCommentUsecase {
  type Input = (Int, String)
  type Output = Option[Post]
}

trait UsesRegisterCommentUsecase {
  val registerCommentUsecase: RegisterCommentUsecase = new RegisterCommentUsecase {
    override val postRepository: PostRepository = postRepository
  }
}