package core

class GameRulesTest extends GameOfLifeBaseTest {

  behavior of "Dead cell rules"

  they should s"result in alive cell when there's just enough neighbours" in {
    val neighbours = NeighboursCount(3)
    val newCellsState = GameLogic(Dead, neighbours)

    newCellsState mustBe Alive
  }

  they should "result in dead cell when there's not enough neighbours" in {
    val neighbours = NeighboursCount(2)
    val newCellState = GameLogic(Dead, neighbours)

    newCellState mustBe Dead
  }

  they should "result in dead cell when there's too much neighbours" in {
    val neighbours = NeighboursCount(4)
    val newCellState = GameLogic(Dead, neighbours)

    newCellState mustBe Dead
  }

  behavior of "Alive cell rules"

  they should "result in alive cell when there's just enough neighbours" in {
    val neighbours = NeighboursCount(2)
    val newCellState = GameLogic(Alive, neighbours)

    newCellState mustBe Alive
  }

  they should "result in dead cell when there's not enough neighbours" in {
    val neighbours = NeighboursCount(1)
    val newCellState = GameLogic(Alive, neighbours)

    newCellState mustBe Dead
  }

  they should "result in dead cell when there's too much neighbours" in {
    val neighbours = NeighboursCount(4)
    val newCellState = GameLogic(Alive, neighbours)

    newCellState mustBe Dead
  }
}

