/**
  * Created by ryota on 2016/08/14.
  */

import adaptor.API.API
import adaptor.repositoryImpl.onMemory.{UsesPostRepository, UsesTopicRepository}
import usecase.command.Comment.UsesRegisterCommentUsecase
import usecase.command.Post.UsesRegisterPostUsecase
import usecase.command.Topic.UsesRegisterTopicUseCase
import usecase.query.Topic.UsesGetAllTopicUsecase

object Main
  extends UsesRegisterPostUsecase
    with UsesRegisterTopicUseCase
    with UsesGetAllTopicUsecase
    with UsesRegisterCommentUsecase
    with UsesTopicRepository
    with UsesPostRepository {

  def sampleRun(): Unit = {


    registerTopicUseCase.call("file")

    val topic = getAllTopicUsecase.call()
    println(topic)

    val res = registerTopicUseCase.andThen(getAllTopicUsecase).call(("fire1", Nil))
    println(res)

    topicRepository.findAll().flatMap(topicList => {
      val headTopic = topicList.head
      registerPostUsecase.call(headTopic.id.value, "hoge")
      registerPostUsecase.call(headTopic.id.value, "hoge2")

      postRepository.findPostListByTopicId(headTopic.id)

    }).map(postList => {
      postList.foreach(post => {
        println(post.id, post.text)
        post.commentList.value.foreach(comment => println(comment))
      })
      postList.head
    }).map(post => {
      registerCommentUsecase.call(post.id.value, "comment!")
      postRepository.findPostById(post.id)
      //.map(post => post.commentList)
    }).map({
      case Some(post) =>
        println(post.id, post.text)
        post.commentList.value.foreach(comment => println(comment.text))
        Some(0)

      case None => None
    })

  }

  def main(args: Array[String]): Unit = {
    API.run()
  }
}