/**
  * Created by ryota on 2016/09/28.
  */
import scala.scalajs._
/**
  * Created by ryota on 2016/09/27.
  */
object App extends js.JSApp {
  def main(): Unit = {
//    val topicRepository: TopicRepository = TopicRepositoryOnMemoryClient()
//    val topic = Topic("Hello")
//    val f = topicRepository.store(topic)
//    f.onSuccess({ case _ => println("comp") })
//    f.onFailure({ case _ => print("") })
//    println(topic)
//    println(topicRepository)
//
//    topicRepository.findAll()

    Flux.test()
  }
}
