package domain.Repository

import domain.Entity.Topic

/**
  * Created by ryota on 2016/08/14.
  */
trait TopicRepository {
  def getTopic(id: ): Option[Topic]
}
