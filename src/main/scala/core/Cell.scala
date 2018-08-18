package core

sealed trait Cell {
  def alive: Boolean
  def dead: Boolean = !alive
}

case object Alive extends Cell {
  override val alive: Boolean = true
}

case object Dead extends Cell {
  override val alive: Boolean = false
}

