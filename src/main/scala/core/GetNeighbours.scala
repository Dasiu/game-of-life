package core

object GetNeighbours {

  def apply(field: Field, board: Board): NeighboursCount = {
    val fields = GetAdjacentFields(field)
    val aliveNeighboursCount = countAliveNeighbours(board, fields)

    NeighboursCount(aliveNeighboursCount)
  }

  private def countAliveNeighbours(board: Board, fields: Iterable[Field]) = {
    fields
      .map(board.apply)
      .count(_.alive)
  }

}

final case class Field(x: Int, y: Int)

class Board(cellByField: Map[Field, Cell]) {

  def fieldsWithAliveCell: Iterable[Field] = {
    aliveCellByField.keySet
  }


  private val aliveCellByField = cellByField.filter(_._2.alive)

  def apply(field: Field): Cell = {
    cellByField.getOrElse(field, Dead)
  }

  def isEmpty: Boolean = {
    cellByField.values.exists(_.dead)
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Board]

  override def equals(other: Any): Boolean = other match {
    case that: Board =>
      (that canEqual this) &&
        aliveCellByField == that.aliveCellByField
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(aliveCellByField)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

object Board {
  def apply(cellByField: Map[Field, Cell]): Board = {
    new Board(cellByField)
  }
}