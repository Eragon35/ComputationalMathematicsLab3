package prog


object ConsoleHandler {
  def functionHandler(line: String): Option[(Double => Double)] = {
    Option(
      line.trim.toLowerCase match {
        case "1" => first
        case "2" => second
        case "3" => third
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
  private def forth(x: Double): Double = -1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95
  
  def limitHandler(line: String): (Double, Double)= {
    val input = line.trim.split(" ")
    val left = input(0).toDouble
    val right = input(1).toDouble
    (left, right)
  }


}
