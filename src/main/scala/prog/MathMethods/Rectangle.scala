package prog.MathMethods

import scala.annotation.tailrec


object Rectangle {
  def solve(func: Double => Double, left: Double, right: Double, accuracy: Double): Unit = {
    var n: Int = 4
    var step: Double = (right - left) / n

    def changeStep(): Unit = {
      n = n + 1
      step = (right - left) / n
    }

    @tailrec
    def findIntegral(x: Double, answer: Double = 0): Double = {
      if (x >= right) answer
      else findIntegral(x+step, answer + func(x) * step)
    }
    @tailrec
    def findMiddleIntegral(x: Double, answer: Double = 0): Double = {
      if (x >= right) answer
      else findMiddleIntegral(x + step, answer + func(x + step / 2) * step)
    }

    try {
      // finding left reactangle
      var previousAnswer = func(left) * step + findIntegral(left + step)
      changeStep()
      var answer = func(left) * step + findIntegral(left + step)
      while (Math.abs(previousAnswer - answer) >= accuracy) {
        if (previousAnswer.isInfinite) throw ArithmeticException("Деление на 0")
        previousAnswer = answer
        changeStep()
        answer = func(left) * step + findIntegral(left + step)
      }
      val leftAnswer = answer
      val nLeft = n

      n = 4 // finding middle rectangle
      previousAnswer = findMiddleIntegral(left)
      changeStep()
      answer = findMiddleIntegral(left)
      while (Math.abs(previousAnswer - answer) >= accuracy) {
        previousAnswer = answer
        changeStep()
        answer = findMiddleIntegral(left)
      }
      val middleAnswer = answer
      val nMiddle = n

      n = 4 // finding right rectangle
      previousAnswer = func(right) * step + findIntegral(left + step)
      changeStep()
      answer = func(right) * step + findIntegral(left + step)
      while (Math.abs(previousAnswer - answer) >= accuracy) {
        previousAnswer = answer
        changeStep()
        answer = func(right) * step + findIntegral(left + step)
      }
      val rightAnswer = answer
      val nRight = n
      println(s"Метод прямоугольников:\n\tлевых = $leftAnswer, за $nLeft итераций" +
        s"\n\tсредних = $middleAnswer, за $nMiddle итераций\n\tправых = $rightAnswer, за $nRight итераций")
    } catch {
      case e: ArithmeticException =>
        if (left == -right) println("Метод прямоугольников, интеграл = 0.0")
        else println("Невозможно вычислить, неустранимый разрыв второго рода")
    }
    

  }
}
