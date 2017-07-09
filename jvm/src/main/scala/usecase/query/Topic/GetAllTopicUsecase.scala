package usecase.query.Topic

import adaptor.Dtos._
import domain.Repository.TopicRepository
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */
trait GetAllTopicUsecase
  extends Usecase[GetAllTopicUsecase.Input, GetAllTopicUsecase.Output] {
  val topicRepository: TopicRepository
  def call(input: GetAllTopicUsecase.Input): GetAllTopicUsecase.Output = {
    topicRepository.findAll().map(topicList => topicList.map(TopicToDto.fromEntity))
  }
}

object GetAllTopicUsecase {
  type Input = Any
  type Output = Option[List[TopicDto]]
}

trait UsesGetAllTopicUsecase {
  val topicRepository: TopicRepository
  val getAllTopicUsecase: GetAllTopicUsecase = new GetAllTopicUsecase {
    override val topicRepository: TopicRepository = topicRepository
  }
}