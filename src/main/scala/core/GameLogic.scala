package core

object GameLogic {

  object DeadCellLogic {
    val justEnoughNeighboursToLive: Int = 3

    def apply(neighboursCount: NeighboursCount): Cell = {
      if (neighboursCount.value == justEnoughNeighboursToLive) Alive
      else Dead
    }
  }

  object AliveCellLogic {
    val justEnoughNeighboursToLive: Set[Int] = Set(2, 3)

    def apply(neighboursCount: NeighboursCount): Cell = {
      if (justEnoughNeighboursToLive.contains(neighboursCount.value)) Alive
      else Dead
    }
  }

  def apply(cell: Cell, neighboursCount: NeighboursCount): Cell = {
    val cellLogic = if (cell.alive) AliveCellLogic.apply _ else DeadCellLogic.apply _
    cellLogic(neighboursCount)
  }

}
