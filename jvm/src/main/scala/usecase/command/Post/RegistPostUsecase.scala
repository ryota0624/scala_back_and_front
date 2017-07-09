package usecase.command.Post

import domain.Entity.Post.Post
import domain.Entity.Topic.{Topic, TopicId}
import domain.Repository.{PostRepository, TopicRepository}
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */
trait RegisterPostUsecase
  extends Usecase[RegisterPostUsecase.Input, RegisterPostUsecase.Output] {
  val topicRepository: TopicRepository
  val postRepository: PostRepository
  def call(input: RegisterPostUsecase.Input): RegisterPostUsecase.Output = {
    input match {
      case (topicId: Int, postText: String) => topicRepository.findTopicId(TopicId(topicId))
        .map((targetTopic) => {
          val post = Post(postText, topicId = targetTopic.id)
          targetTopic.addPost(post)
          topicRepository.update(targetTopic)
            .map((_) => postRepository.store(post))
          targetTopic
        })
    }
  }
}

object RegisterPostUsecase {
  type Input = (Int, String)
  type Output = Option[Topic]
}

trait UsesRegisterPostUsecase {
  val topicRepository: TopicRepository
  val postRepository: PostRepository
  val registerPostUsecase: RegisterPostUsecase = new RegisterPostUsecase {
    val topicRepository: TopicRepository = topicRepository
    val postRepository: PostRepository = postRepository
  }
}