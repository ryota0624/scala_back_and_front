package adaptor.API.routing
import adaptor.controller.getAllTopicController
import akka.http.scaladsl.server.Directives._


/**
  * Created by ryota on 2016/08/14.
  */
object topicRouting {
  def route() =
    pathSingleSlash {
      get {
        getAllTopicController.call()
      }
    }
}
