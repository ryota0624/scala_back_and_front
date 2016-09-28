package adaptor.presenter.json

import adaptor.API.JsonSupport
import akka.http.scaladsl.server.Directives
import usecase.adaptor.Presenter.PostPresenter

/**
  * Created by ryota on 2016/08/20.
  */
class PostPresenterImplJson
  extends PostPresenter
  with Directives
  with PresenterTrait
  with JsonSupport {
//  def show(topic: TopicDto): StandardRoute = complete(topic)
//  def fail(err: Error): StandardRoute = super.failWith(err)
}
