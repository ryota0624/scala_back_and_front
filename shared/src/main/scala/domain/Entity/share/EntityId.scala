package domain.Entity.share

import scala.util.Random

/**
  * Created by ryota on 2016/08/14.
  */
object EntityId {
  def create(): Int = Random.nextInt()
}