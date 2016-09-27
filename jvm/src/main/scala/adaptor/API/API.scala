package adaptor.API

import adaptor.API.routing.topicRouting
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.io.StdIn

/**
  * Created by ryota on 2016/08/14.
  */
object API {
  def run() = {
    implicit val system = ActorSystem("api")
    implicit val materializer = ActorMaterializer()
    implicit val ec = system.dispatcher


    val interface = "localhost"
    val port = 8080
    val binding = Http().bindAndHandle(topicRouting.route(), interface, port)

    binding.onFailure {
      case err: Exception =>
        println(err, s"Failed to bind to $interface $port")
    }

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    binding
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
