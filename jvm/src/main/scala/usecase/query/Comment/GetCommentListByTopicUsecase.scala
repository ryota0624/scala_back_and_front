package usecase.query.Comment

import domain.Entity.Post.Comment.Comment
import domain.Entity.Topic.TopicId
import domain.Repository.{PostRepository, TopicRepository}
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */

class GetCommentListByTopicUsecase(postRepository: PostRepository, topicRepository: TopicRepository)
  extends Usecase[GetCommentListByTopicUsecase.Input, GetCommentListByTopicUsecase.Output] {
  def call(topicId: GetCommentListByTopicUsecase.Input): GetCommentListByTopicUsecase.Output = {
    topicRepository.findTopicId(TopicId(topicId))
    .flatMap(topic => postRepository.findPostListByTopicId(topic.id))
    .map(_.map(_.commentList.value)
    .reduceLeft[List[Comment]]((prev, cur) => prev:::cur))
  }
}

object GetCommentListByTopicUsecase extends {
  type Output = Option[List[Comment]]
  type Input = Int
}