package usecase.command.Post

import domain.Entity.Post.Post
import domain.Entity.Topic.{Topic, TopicId}
import domain.Repository.{PostRepository, TopicRepository}
import usecase.helpers.Usecase

/**
  * Created by ryota on 2016/08/14.
  */
class RegistPostUsecase(topicRepository: TopicRepository, postRepository: PostRepository)
  extends Usecase[RegistPostUsecase.Input, RegistPostUsecase.Output] {
  def call(input: RegistPostUsecase.Input): RegistPostUsecase.Output = {
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

object RegistPostUsecase {
  type Input = (Int, String)
  type Output = Option[Topic]
}