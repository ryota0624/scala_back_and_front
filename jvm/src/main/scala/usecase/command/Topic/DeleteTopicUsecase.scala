package usecase.command.Topic

import adaptor.Dtos.{TopicDto, TopicToDto}
import domain.Entity.Topic.TopicId
import domain.Repository.TopicRepository
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */
class DeleteTopicUsecase(topicRepository: TopicRepository)
  extends Usecase[DeleteTopicUsecase.Input, DeleteTopicUsecase.Output] {
  def call(topicIdInt: DeleteTopicUsecase.Input): DeleteTopicUsecase.Output = {
    topicRepository.findTopicId(TopicId(topicIdInt))
      .flatMap(topic => topicRepository.remove(topic).map(_ => topic))
      .map(TopicToDto.fromEntity)
  }
}

object DeleteTopicUsecase {
  type Input = Int
  type Output = Option[TopicDto]
}