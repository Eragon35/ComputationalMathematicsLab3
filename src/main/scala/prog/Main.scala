package prog

import prog.ConsoleHandler._
import prog.MathMethods._


object Main {
  def main(args: Array[String]): Unit = {
    println(
      """ Вариант №2
        | Заданная функция 1: −3x^3 − 5x^2 + 4x - 2
        | Функция 2: sin(x)/x
        | Функция 3: x^3 − 0.78x^2 − 0.826x + 0.145
        | Функция 4: 1/x""".stripMargin)

    while (true) {
      functionHandler() match {
        case Some(value) =>
          val limits = limitHandler()
          Trapeziodal.solve(value, limits._1, limits._2, limits._3) // ._1 - left
          Rectangle.solve(value, limits._1, limits._2, limits._3) // ._2 - right
          Simpson.solve(value, limits._1, limits._2, limits._3) // ._3 - accuracy
        case None => Console.err.println("Some error")
      }
    }
  }
}
