package adaptor.presenter.console

import adaptor.Dtos.TopicDto
import usecase.adaptor.Presenter.AllTopicPresenter

/**
  * Created by ryota on 2016/08/14.
  */

class AllTopicPresenterImplConsole extends AllTopicPresenter with PresenterTrait {
  def show(list: List[TopicDto]) = println(list)
}
