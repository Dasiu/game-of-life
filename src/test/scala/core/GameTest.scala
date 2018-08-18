package core

class GameTest extends GameOfLifeBaseTest {

  behavior of "NextTurn"

  it should "result in empty board when previous board contained only one alive cell" in {
    val currentBoard = Board(Map(Field(0, 0) -> Alive))
    val nextBoard = NextTurn(currentBoard)

    nextBoard.isEmpty mustBe true
  }

  it should "result in board with 4 alive cells when previous board contained two neighbours" in {
    val currentBoard = Board(Map(
      Field(0, 0) -> Alive,
      Field(0, 1) -> Alive,
      Field(1, 1) -> Alive,
    ))

    val expectedBoard = Board(Map(
      Field(0, 0) -> Alive,
      Field(0, 1) -> Alive,
      Field(1, 1) -> Alive,

      Field(1, 0) -> Alive,
    ))

    val nextBoard = NextTurn(currentBoard)

    nextBoard mustBe expectedBoard
  }

  it should "result in same board when previous one was in invariant state" in {
    val currentBoard = Board(Map(
      Field(0, 0) -> Alive,
      Field(0, 1) -> Alive,
      Field(1, 1) -> Alive,
      Field(1, 0) -> Alive,
    ))
    val nextBoard = NextTurn(currentBoard)

    nextBoard mustBe currentBoard
  }

  it should "result in blinker oscillator" in {
    val blinkerHorizontalState  = Board(Map(
      Field(-1, 0) -> Alive,
      Field(0, 0) -> Alive,
      Field(1, 0) -> Alive,
    ))

    val blinkerVerticalState = Board(Map(
      Field(0, -1) -> Alive,
      Field(0, 0) -> Alive,
      Field(0, 1) -> Alive,
    ))

    val nextBoard = NextTurn(blinkerHorizontalState)

    nextBoard mustBe blinkerVerticalState
    NextTurn(nextBoard) mustBe blinkerHorizontalState
  }

}

object NextTurn {
  def apply(currentBoard: Board): Board = {
    val newCellByField: Map[Field, Cell] = currentBoard.fieldsWithAliveCell
        .flatMap(field => GetAdjacentFields(field))
        .map(field => {
          val neighboursCount = GetNeighbours(field, currentBoard)
          val cell = currentBoard(field)
          val newCellState = GameLogic(cell, neighboursCount)

          field -> newCellState
        })
        .toMap

    Board(newCellByField)
  }
}









