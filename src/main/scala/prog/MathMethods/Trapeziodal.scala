package prog.MathMethods

import scala.annotation.tailrec


object Trapeziodal {
  def solve(func: Double => Double, left: Double, right: Double, step: Double): Unit = {
    findIntegral(func(left), left)

    @tailrec
    def findIntegral(y0: Double, x: Double, answer: Double = 0): Unit = {
      if (x >= right) println(s"Метод трапеций = $answer")
      else {
        findIntegral(func(x+step), x+step, answer + (y0 + func(x+step)) / 2 * step)
      }
    }
  }
}
