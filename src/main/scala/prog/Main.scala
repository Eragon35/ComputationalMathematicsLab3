package prog

import prog.ConsoleHandler.{functionHandler, limitHandler}
import prog.MathMethods._

import scala.io.StdIn

object Main {
//  var accuracy: Double = 0.01
//  var left: Double = -3
//  var right: Double = -1
//  var n: Int = 4
//  var func: (Double => Double) = Math.pow(left, _)

  def main(args: Array[String]): Unit = {
    println(
      """ Вариант №2
        | Метод трапеций точно
        | Метод прямоугольников (при n=4)
        | Заданная функция 1: −3x^3 − 5x^2 + 4x - 2
        | Функция 2: cos(x)
        | Функция 3: x^3 − 0.78x^2 − 0.826x + 0,145""".stripMargin)

    while (true) {
      println("Введите пределы интегрирования через пробел")
      val limits = limitHandler(StdIn.readLine())
      val step = if (limits._2 - limits._1 > 5) 0.5 else (limits._2 - limits._1) / 10
      functionHandler(StdIn.readLine()) match {
        case Some(value) => Trapeziodal.solve(value, limits._1, limits._2, step)
          Rectangle.solve(value, limits._1, limits._2, step)
        case None => Console.err.println("Some error")
      }
      


    }

  }
}
