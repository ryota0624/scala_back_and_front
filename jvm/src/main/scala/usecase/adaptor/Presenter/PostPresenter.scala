package usecase.adaptor.Presenter

import domain.Entity.Post.Post

/**
  * Created by ryota on 2016/08/20.
  */
trait PostPresenter extends  Presenter {
  def show(post: Post)
}
