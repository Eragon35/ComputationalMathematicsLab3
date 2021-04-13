package prog.MathMethods

import scala.annotation.tailrec


object Trapeziodal {
  def solve(func: Double => Double, left: Double, right: Double, accuracy: Double): Unit = {
    var n: Int = 4
    var step: Double = (right - left) / n
    
    def changeStep(): Unit = {
      n = n + 1
      step = (right - left) / n
    }
    
    @tailrec
    def findIntegral(y0: Double, x: Double, answer: Double = 0): Double = {
      if (x >= right) answer
      else findIntegral(func(x+step), x+step, answer + (y0 + func(x+step)) / 2 * step)
    }
    
    var solution: Option[Double] = None
    try {
      var previousAnswer = findIntegral(func(left), left)
      changeStep()
      var answer = findIntegral(func(left), left)
      while (Math.abs(previousAnswer - answer) >= accuracy) {
        if (previousAnswer.isInfinite) throw ArithmeticException("Деление на 0")
        previousAnswer = answer
        changeStep()
        answer = findIntegral(func(left), left)
      }
      solution = Option(answer)
    } catch {
      case e: ArithmeticException => if (left == -right) solution = Option(0.0)
    }
    n -= 3
    solution match {
      case Some(value) => println(s"Метод трапеций = $value, за $n итераций")
      case None => println("Невозможно вычислить, неустранимый разрыв второго рода")
    }
  }
}
