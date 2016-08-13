package domain.Entity

/**
  * Created by ryota on 2016/08/14.
  */

case class Text(str: String)
class Comment (text: Text){

}

object Comment {
  def apply(text: Text): Comment = new Comment(text)
}
