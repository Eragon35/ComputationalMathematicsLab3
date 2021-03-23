package prog

import prog.ConsoleHandler._
import prog.MathMethods._

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    println(
      """ Вариант №2
        | Метод трапеций точно
        | Метод прямоугольников (при n=4)
        | Заданная функция 1: −3x^3 − 5x^2 + 4x - 2
        | Функция 2: cos(x)
        | Функция 3: x^3 − 0.78x^2 − 0.826x + 0.145
        | Функция 4: −1.38x^3 − 5.42x^2 + 2.57x + 10.95""".stripMargin)

    while (true) {
      println("\nВыберите функцию, набрав её номер")
      functionHandler(StdIn.readLine()) match {
        case Some(value) =>
          println("Введите пределы интегрирования через пробел")
          val limits = limitHandler(StdIn.readLine())
          Trapeziodal.solve(value, limits._1, limits._2, limits._3)
          Rectangle.solve(value, limits._1, limits._2, limits._3)
          Simpson.solve(value, limits._1, limits._2)
        case None => Console.err.println("Some error")
      }
    }
  }
}
