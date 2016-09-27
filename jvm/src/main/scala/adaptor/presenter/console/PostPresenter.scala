package adaptor.presenter.console

import domain.Entity.Post.Post
import usecase.adaptor.Presenter.PostPresenter

/**
  * Created by ryota on 2016/08/20.
  */
class PostPresenterImplConsole extends PostPresenter with PresenterTrait {
  def show(post: Post): Unit = {
    println(post)
  }
}
