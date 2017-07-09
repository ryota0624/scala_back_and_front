package usecase.command.Topic

import adaptor.Dtos.{TopicDto, TopicToDto}
import domain.Entity.Topic.Topic
import domain.Repository.TopicRepository
import usecase.helpers.Usecase
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**

  * Created by ryota on 2016/08/14.
  */
trait RegisterTopicUseCase
  extends Usecase[RegisterTopicUseCase.Input, RegisterTopicUseCase.Output] {
  val topicRepository: TopicRepository
  def call(topicNameStr: RegisterTopicUseCase.Input): RegisterTopicUseCase.Output = {
    val topic = Topic(topicNameStr)
    topicRepository.store(topic)
      .map(_ => TopicToDto.fromEntity(topic))
  }
}

object RegisterTopicUseCase {
  type Input = String
  type Output = Future[TopicDto]
}

trait UsesRegisterTopicUseCase {
  val topicRepository: TopicRepository
  val registerTopicUseCase: RegisterTopicUseCase = new RegisterTopicUseCase {
    val topicRepository = topicRepository
  }
}