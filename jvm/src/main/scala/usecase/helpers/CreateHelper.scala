package usecase.helpers

/**
  * Created by ryota on 2016/09/11.
  */
object CreateHelper {
  def ComposeWithPlugin[P1, I1, I2, O1, O2](u1: (P1 ,I1) => O1, u2: (P1 ,I2) => O2): (P1, (I1, I2)) => (O1, O2) = (plugin: P1, input: (I1, I2)) => {
    (u1(plugin, input._1), u2(plugin, input._2))
  }

  def Composer[I1, I2, O1, O2](u1: (I1) => O1, u2: (I2) => O2): ((I1, I2)) => (O1, O2) = (input: (I1, I2)) => {
    (u1(input._1), u2(input._2))
  }

  def usecaseRunner[InputType, OutputType, PluginInput, PluginOutput]
  (input: InputType, pluginInput: PluginInput,
    usecase: (PluginOutput, InputType) => OutputType, pluginFn: (PluginInput) => PluginOutput): OutputType
  = usecase(pluginFn(pluginInput),input)
}
