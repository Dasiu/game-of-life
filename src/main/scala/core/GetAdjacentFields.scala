package core

object GetAdjacentFields {

  def apply(field: Field): Iterable[Field] = {
    val Field(x, y) = field

    val upperLeft = field.copy(x = x - 1, y = y + 1)
    val upper = field.copy(y = y + 1)
    val upperRight = field.copy(x = x + 1, y = y + 1)

    val right = field.copy(x = x + 1)

    val downRight = field.copy(x = x + 1, y = y - 1)
    val down = field.copy(y = y - 1)
    val downLeft = field.copy(x = x - 1, y = y - 1)

    val left = field.copy(x = x - 1)

    Seq(upperLeft, upper, upperRight, right, downRight, down, downLeft, left)
  }

}