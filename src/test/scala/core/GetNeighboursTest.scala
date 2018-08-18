package core

class GetNeighboursTest extends GameOfLifeBaseTest {

  behavior of "GetNeighbours"

  it should "return 0 when there're not any neighbours around" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map.empty))

    neighbours.value mustBe 0
  }

  it should "return 1 when there is neighbour at upper left side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(-1, 1) -> Alive)))

    neighbours.value mustBe 1
  }

  it should "return 1 when there is neighbour at upper side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(0, 1) -> Alive)))

    neighbours.value mustBe 1
  }

  it should "return 1 when there is neighbour at upper right side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(1, 1) -> Alive)))

    neighbours.value mustBe 1
  }

  it should "return 1 when there is neighbour at right side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(1, 0) -> Alive)))

    neighbours.value mustBe 1
  }

  it should "return 1 when there is neighbour at down right side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(1, -1) -> Alive)))

    neighbours.value mustBe 1
  }

  it should "return 1 when there is neighbour at down side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(0, -1) -> Alive)))

    neighbours.value mustBe 1
  }


  it should "return 1 when there is neighbour at down left side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(-1, -1) -> Alive)))

    neighbours.value mustBe 1
  }

  it should "return 1 when there is neighbour at left side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(-1, 0) -> Alive)))

    neighbours.value mustBe 1
  }

  it should "return 0 when there is someone at far right side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(2, 0) -> Alive)))

    neighbours.value mustBe 0
  }

  it should "return 0 when there is someone at far upper left side" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(-2, 2) -> Alive)))

    neighbours.value mustBe 0
  }

  it should "return 0 when one is alone" in {
    val neighbours = GetNeighbours(Field(0, 0), Board(Map(Field(0, 0) -> Alive)))

    neighbours.value mustBe 0
  }


}
