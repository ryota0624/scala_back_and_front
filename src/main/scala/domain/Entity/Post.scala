package domain.Entity

/**
  * Created by ryota on 2016/08/14.
  */
case class Text(str: String)

class Post(text: Text) {

}

object Post {
  def apply(text: String): Post = new Post(Text(text))
}
