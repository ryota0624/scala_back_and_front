package adaptor.presenter.console

import usecase.adaptor.Presenter.Presenter

/**
  * Created by ryota on 2016/08/14.
  */
trait PresenterTrait extends Presenter {
  def succ() = println("succ")
  def fail() = println("fail")
}

class PresenterImpl extends PresenterTrait with Presenter {
}

object PresenterImpl {
  def apply(): PresenterImpl = new PresenterImpl
}