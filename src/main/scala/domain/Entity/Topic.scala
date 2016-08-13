package domain.Entity

/**
  * Created by ryota on 2016/08/14.
  */
case class Name (name: String) {

}

class Topic (name: Name){
  val id:
}

object Topic {
  def apply(name: String): Topic = new Topic(Name(name))
}