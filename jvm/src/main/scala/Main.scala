/**
  * Created by ryota on 2016/08/14.
  */

import adaptor.API.API
import adaptor.repositoryImpl.onMemory.{PostRepositoryOnMemory, TopicRepositoryOnMemory}
import usecase.command.Comment.RegisterCommentUsecase
import usecase.command.Post.RegistPostUsecase
import usecase.command.Topic.RegisterTopicUseCase
import usecase.query.Topic.GetAllTopicUsecase

object Main {
  def main(args: Array[String]): Unit = {

    val topicRepo = new TopicRepositoryOnMemory
    val postRepo = new PostRepositoryOnMemory

    val useCase = new RegisterTopicUseCase(topicRepo)
    useCase.call("fire")

    val useCase2 = new GetAllTopicUsecase(topicRepo)
    val topic = useCase2.call()
    println(topic)

    val res = useCase.andThen(useCase2).call(("fire1", Nil))
    println(res)

    topicRepo.findAll().flatMap(topicList => {
      val headTopic = topicList.head
      val registPostUsecase = new RegistPostUsecase(topicRepo, postRepo)
      registPostUsecase.call(headTopic.id.value, "hoge")
      registPostUsecase.call(headTopic.id.value, "hoge2")

      postRepo.findPostListByTopicId(headTopic.id)

    }).map(postList => {
      postList.foreach(post => {
        println(post.id, post.text)
        post.commentList.value.foreach(comment => println(comment))
      })
      postList.head
    }).map(post => {
      val registerCommentUsecase = new RegisterCommentUsecase(postRepo)
      registerCommentUsecase.call(post.id.value, "comment!")
      postRepo.findPostById(post.id)
      //.map(post => post.commentList)
    }).map({
      case Some(post) => {
        println(post.id, post.text)
        post.commentList.value.foreach(comment => println(comment.text))
        Some(0)
      }
      case None => None
    })

    API.run()
  }
}