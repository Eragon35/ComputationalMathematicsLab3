package prog.MathMethods

import scala.annotation.tailrec


object Simpson {
  def solve(func: Double => Double, left: Double, right: Double, step: Double, n: Int): Unit = {

    @tailrec
    def findIntegral(x: Double, answer: Double, even: Boolean = false): Double = {
      if (x >= right) answer
      else {
        if (even) findIntegral(x+step, answer + 2 * func(x))
        else findIntegral(x+step, answer + 4 * func(x), true)
      }
    }
    
    val answer = step / 3 * findIntegral(left + step, func(left) + func(right))
    val simpleAnswer = (right - left) / 6 * (func(left) + func(right) + 4 * func((right + left) / 2)) // use Simpson's 1/3 rule

    println(s"Метод Симпсона:\n\tПравило 1/3 = $simpleAnswer\n\tПри n = $n ответ = $answer")
  }
}
