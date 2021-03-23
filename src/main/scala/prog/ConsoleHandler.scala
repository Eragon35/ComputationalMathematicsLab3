package prog

import scala.io.StdIn


object ConsoleHandler {
  def functionHandler(line: String): Option[(Double => Double)] = {
    Option(
      line.trim.toLowerCase match {
        case "1" => first
        case "2" => second
        case "3" => third
        case "4" => forth
        case "exit" | "e" | "no" | "n" | "учше" =>
          print("Хорошего Вам дня!")
          System.exit(0)
          return None
        case _ => Console.err.println("Такой функции нет, установлена первая функция")
          first
      }
    )
  }

  private def first(x: Double): Double = -3 * Math.pow(x, 3) - 5 * Math.pow(x, 2) + 4 * x - 2
  private def second(x: Double): Double = Math.cos(x)
  private def third(x: Double): Double = Math.pow(x, 3) - 0.78 * Math.pow(x, 2) - 0.826 * x + 0.145
  private def forth(x: Double): Double = Math.pow(x, 2)

  def limitHandler(line: String): (Double, Double, Double)= {
    try {
      val input = line.trim.split(" ")
      val left = input(0).toDouble
      val right = input(1).toDouble
      println("Введите число разбиений") // TODO ask teacher about accuracy & parts
      val n = StdIn.readInt()
      val step = Math.abs(right - left) / n
      if (right <= left) throw IllegalArgumentException("Окончание интервала не может быть меньше начала")
      else if (n <= 0) throw IllegalArgumentException("Число разбиений не может быть меньше или равно 0")
      else (left, right, step)
    } catch {
      case e : Exception => Console.err.println("Ошибка чтения: " + e.getMessage)
        println("Вычисляем с параметрами по умолчанию (-3, -1, 0.01)")
        return (-3, -1, 0.01)
    }
  }
}
