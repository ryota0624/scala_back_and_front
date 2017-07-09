
/**
  * Created by ryota on 2016/11/26.
  */
trait Action {
}

class Flux {
  type DispatchHandler = (Action) => Unit
  private var handlers: Seq[DispatchHandler] = Seq()
  def dispatch(action: Action): Unit = {
    handlers.foreach { _.apply(action) }
  }

  def register(fun: DispatchHandler) = {
    handlers = handlers ++ Seq(fun)
  }
}

case class Todo(id: Int, title: String) {
  def update(title: String):Todo = Todo(this.id, title)
}

case class StoreTodo(id: Int, title: String) extends Action
case class UpdateTodo(id: Int, title: String) extends Action

object Flux {
  def test() {
    val flux = new Flux
    var todos = Map[Int, Todo]()
    flux.register {
      case StoreTodo(id, title) => todos = todos.updated(id, Todo(id, title))
      case _ =>
    }

    flux.register {
      case UpdateTodo(id, title) =>
        todos.get(id).foreach { (todo) =>
          todos = todos.updated(id, todo.update(title))
        }
      case _ =>
    }

    flux.dispatch(StoreTodo(19, "test"))
    println(todos)
    flux.dispatch(UpdateTodo(19, "testtest"))
    println(todos)
  }
}