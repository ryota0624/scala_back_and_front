package usecase.helpers

/**
  * Created by ryota on 2016/09/21.
  */
abstract class Usecase[I, O] {
  def call(input: I): O
//  def andThen[I2, O2](usecase: Usecase[I2, O2]): ((I, I2)) => (O, O2) = {
//    (input: (I, I2)) => {
//      (this.call(input._1), usecase.call(input._2))
//    }
//  }
  def andThen[I2, O2](usecase: Usecase[I2, O2]): Usecase[(I, I2), (O, O2)] = {
    val u1 = this
    type Input = (I, I2)
    type Output = (O, O2)
    class U extends Usecase[Input, Output] {
      def call(input: Input): Output = {
        (u1.call(input._1), usecase.call(input._2))
      }
    }
    new U()
  }
}
