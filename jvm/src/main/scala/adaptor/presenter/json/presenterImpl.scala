package adaptor.presenter.json

import akka.http.scaladsl.server.{Directives, StandardRoute}
import usecase.adaptor.Presenter.Presenter

/**
  * Created by ryota on 2016/08/14.
  */
trait PresenterTrait
  extends Presenter
  with Directives {
  def fail(err: Error): StandardRoute = failWith(err)
}
