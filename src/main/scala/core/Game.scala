package core

trait Game {

  protected def stateStreamFactory: StateStreamFactory[GameState]

  type GameState

  def play(initialBoardSetting: GameState): StateStream[GameState] = {
    stateStreamFactory.from(initialBoardSetting)
  }

}

trait Strategy[State] {
  def next(state: State): State
}

trait StateStream[State]

trait StateStreamFactory[State] {
  def from(initialState: State): StateStream[State]
}

class A {
  def method(): String = {
    "Aaa"
  }
}

class B extends A
class C extends B {
  override def method: String = {
    "Cccc"
  }
}