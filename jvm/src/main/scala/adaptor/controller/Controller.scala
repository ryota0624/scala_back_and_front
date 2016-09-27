package adaptor.controller

import usecase.helpers.Usecase


/**
  * Created by ryota on 2016/09/28.
  */
trait Controller {
  def excute[I, O](usecase: Usecase[I, O], input: I): O = {
    usecase.call(input)
  }
}
