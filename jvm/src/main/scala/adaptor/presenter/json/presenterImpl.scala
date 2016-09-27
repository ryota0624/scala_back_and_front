package adaptor.presenter.json

import usecase.adaptor.Presenter.Presenter

/**
  * Created by ryota on 2016/08/14.
  */
trait PresenterTrait extends Presenter {
}

class PresenterImpl extends PresenterTrait with Presenter {
}

object PresenterImpl {
  def apply(): PresenterImpl = new PresenterImpl
}