package prog.MathMethods

import scala.annotation.tailrec
import scala.util.control.Breaks.break


object Simpson {
  def solve(func: Double => Double, left: Double, right: Double, accuracy: Double): Unit = {
    var n: Int = 4
    var step: Double = (right - left) / n

    def changeStep(): Unit = {
      n = n + 1
      step = (right - left) / n
    }

    @tailrec
    def findIntegral(x: Double, answer: Double, even: Boolean = false): Double = {
      var tempAnswer = func(x)
      if (tempAnswer.isNaN) tempAnswer = 0
      if (x >= right) answer
      else if (even) findIntegral(x + step, answer + 2 * tempAnswer)
      else findIntegral(x + step, answer + 4 * tempAnswer, true)
    }
    
    
    var previousAnswer = findIntegral(func(left), left)
    changeStep()
    var solution: Option[Double] = None
    try {
      var answer = step / 3 * findIntegral(left + step, func(left) + func(right))
      while (Math.abs(previousAnswer - answer) >= accuracy) {
        if (previousAnswer.isInfinite) throw ArithmeticException("Деление на 0")
        previousAnswer = answer
        changeStep()
        answer = step / 3 * findIntegral(left + step, func(left) + func(right))
      }
      solution = Option(answer)
    } catch {
      case e: ArithmeticException => if (left == -right) solution = Option(0.0)
    }
    val simpleAnswer = (right - left) / 6 * (func(left) + func(right) + 4 * func((right + left) / 2)) // use Simpson's 1/3 rule
    solution match {
      case Some(value) => println(s"Метод Симпсона:\n\tПравило 1/3 = $simpleAnswer\n\tза $n итераций ответ = $value")
      case None => println("Невозможно вычислить, неустранимый разрыв второго рода")
    }
  }
}
