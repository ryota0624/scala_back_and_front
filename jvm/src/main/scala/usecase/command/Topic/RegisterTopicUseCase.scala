package usecase.command.Topic

import adaptor.Dtos.{TopicDto, TopicToDto}
import domain.Entity.Topic.Topic
import domain.Repository.TopicRepository
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */
class RegisterTopicUseCase(topicRepository: TopicRepository)
  extends Usecase[RegisterTopicUseCase.Input, RegisterTopicUseCase.Output] {
  def call(topicNameStr: RegisterTopicUseCase.Input): RegisterTopicUseCase.Output = {
    val topic = Topic(topicNameStr)
    topicRepository.store(topic)
      .map(_ => TopicToDto.fromEntity(topic))
  }
}

object RegisterTopicUseCase {
  type Input = String
  type Output = Option[TopicDto]
}