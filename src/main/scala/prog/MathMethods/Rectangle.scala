package prog.MathMethods

import scala.annotation.tailrec

object Rectangle {
  def solve(func: Double => Double, left: Double, right: Double, step: Double): Unit = {
    val step = if (right - left > 5) 0.5 else (right - left) / 10

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
//    println(step + " " + answer)
    val leftAnswer = func(left) * step + answer
    val rightAnswer = answer + func(right) * step
    val middleAnswer = findMiddleIntegral(left)
    
    println(s"Метод прямоугольников:\nМетод левых = $leftAnswer\nМетод правых = $rightAnswer\nМетод средних = $middleAnswer")
  }
  
}
