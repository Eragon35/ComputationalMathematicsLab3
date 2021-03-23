package prog.MathMethods

object Simpson {
  def solve(func: Double => Double, left: Double, right: Double): Unit = {

    val h = (right - left) / 4
    val leftAnswer = func(left)
    val rightAnswer = func(right)
    val middleAnswer = func((right + left) / 2)
    val leftQuatterAnswer = func(left + h)
    val rightQuatterAnswer = func(right - h)
    val answer = h / 3 * (leftAnswer + 4 * (leftQuatterAnswer + rightQuatterAnswer) + 2 * middleAnswer + rightAnswer)
    val simpleAnswer = (right - left) / 6 * (leftAnswer + rightAnswer + 4 * middleAnswer) // use Simpson's 1/3 rule
    println(s"Метод Симпсона:\n\tПравило 1/3 = $simpleAnswer\n\tПри n = 4 ответ = $answer")
  }
}
