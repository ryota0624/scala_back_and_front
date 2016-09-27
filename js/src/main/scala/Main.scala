/**
  * Created by ryota on 2016/09/28.
  */

import domain.Entity.Topic.Topic

import scala.scalajs._
/**
  * Created by ryota on 2016/09/27.
  */
object Main extends js.JSApp {
  def main(): Unit = {
    val topic = Topic("Hello")
    println(topic.name)
  }
}
