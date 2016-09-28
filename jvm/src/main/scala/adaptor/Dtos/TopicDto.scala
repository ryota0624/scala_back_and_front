package adaptor.Dtos

import domain.Entity.Topic.Topic

/**
  * Created by ryota on 2016/09/28.
  */
final case class TopicDto(name: String, id: Int)

object TopicToDto {
  def fromEntity(topic: Topic): TopicDto = {
    TopicDto(topic.name.value, topic.id.value)
  }
}
