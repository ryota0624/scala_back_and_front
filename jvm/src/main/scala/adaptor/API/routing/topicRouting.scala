package adaptor.API.routing
import adaptor.API.JsonSupport
import adaptor.controller._
import akka.http.scaladsl.server.Directives._
/**
  * Created by ryota on 2016/08/14.
  */
object topicRouting extends JsonSupport {
  def route() =
    pathSingleSlash {
      get {
        getAllTopicController.call()
      } ~ post {
        entity(as [TopicNameRequest]) {
          request => registerTopicController.call(request)
        }
      } ~ delete {
        entity(as [TopicIdRequest]) {
          request => deleteTopicController.call(request)
        }
      }
    }
}
