package prog.MathMethods

object Simpson {
  def solve(func: Double => Double, left: Double, right: Double): Unit = {
    
    val answer = (right - left) / 6 * (func(left) + func(right) + 4 * func((right - left) / 2)) // use Simpson's 1/3 rule
    println(s"Метод Симпсона = $answer")
  }
  
//  if you want Simpson's rule with n = 4
//  val h = (right - left) / 4
//  val leftAnswer = func(left)
//  val rightAnswer = func(right)
//  val middleAnswer = func((right - left) / 2)
//  val leftQuatterAnswer = func(left + h)
//  val rightQuatterAnswer = func(right - h)
//  val answer = h / 3 * (leftAnswer + 4 * (leftQuatterAnswer + rightQuatterAnswer) + 2 * middleAnswer + rightAnswer)
}
