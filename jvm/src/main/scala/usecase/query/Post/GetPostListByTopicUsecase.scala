package usecase.query.Post

import domain.Entity.Post.Post
import domain.Entity.Topic._
import domain.Repository.PostRepository
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */
class GetPostListByTopicUsecase(postRepository: PostRepository)
  extends Usecase[GetPostListByTopicUsecase.Input, GetPostListByTopicUsecase.Output]{
  def call(topicId: GetPostListByTopicUsecase.Input):GetPostListByTopicUsecase.Output = {
    postRepository.findPostListByTopicId(TopicId(topicId))
  }
}

object GetPostListByTopicUsecase {
  type Input = Int
  type Output = Option[List[Post]]
}