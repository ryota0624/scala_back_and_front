package usecase.adaptor.Presenter

import domain.Entity.Post.Post

/**
  * Created by ryota on 2016/08/14.
  */
trait PostListPresenter extends Presenter {
  def show(posts: List[Post])
}
