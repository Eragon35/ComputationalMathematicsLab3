package prog.MathMethods

import scala.annotation.tailrec

object Rectangle {
  def solve(func: Double => Double, left: Double, right: Double, step: Double): Unit = {

    @tailrec
    def findIntegral(x: Double, answer: Double = 0): Double = {
      if (x > right - step) answer
      else findIntegral(x+step, answer + func(x) * step)
    }

    @tailrec
    def findMiddleIntegral(x: Double, answer: Double = 0): Double = {
      if (x > right) answer
      else findMiddleIntegral(x+step, answer + func(x + step / 2) * step)
    }
    
    val answer = findIntegral(left + step)
    val leftAnswer = func(left) * step + answer
    val rightAnswer = answer + func(right) * step
    val middleAnswer = findMiddleIntegral(left)
    
    println(s"Метод прямоугольников:\n\tлевых = $leftAnswer\n\tсредних = $middleAnswer\n\tправых = $rightAnswer")
  }
}
