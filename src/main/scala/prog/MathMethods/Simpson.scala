package prog.MathMethods

import scala.annotation.tailrec


object Simpson {
  def solve(func: Double => Double, left: Double, right: Double, step: Double, n: Int): Unit = {

    @tailrec
    def findIntegral(x: Double, answer: Double): Double = {
      if (x >= right - step) answer
      else {
        if (((x - left) / step).toInt % 2 == 0) findIntegral(x+step, answer + 2 * func(x))
        else findIntegral(x+step, answer + 4 * func(x))
      }
    }

    @tailrec
    def findIntegralN(n: Int, answer: Double): Double = {
      if (left + step * n >= right - step) answer
      else {
        if (n % 2 == 0) findIntegralN(n+1, answer + 2 * func(left + step * n))
        else findIntegralN(n+1, answer + 4 * func(left + step * n))
      }
    }
    val answer = ((right - left) / n) / 3 * findIntegral(left + step, func(left) + func(right))
    val answerN = ((right - left) / n) / 3 * findIntegralN(1, func(left) + func(right))
    val simpleAnswer = (right - left) / 6 * (func(left) + func(right) + 4 * func((right + left) / 2)) // use Simpson's 1/3 rule

    println(s"Метод Симпсона:\n\tПравило 1/3 = $simpleAnswer\n\tПри n = 4 ответ = $answerN метод без N = $answer")
  }
}
