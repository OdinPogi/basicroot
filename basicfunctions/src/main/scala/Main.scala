
object Main extends App {
// implicit approach
val add = (x: Int, y: Int) => { x + y }
val add = (x: Int, y: Int) => x + y

// explicit approach
val add: (Int, Int) => Int = (x,y) => { x + y }
val add: (Int, Int) => Int = (x,y) => x + y

println("\n--function--")
def add(x:Int, y:Int) = x + y
println("def add(x:Int, y:Int) = x + y")
println("add(20,30)")
println(add(20,30))

 println("--function currying--")
def add2(x:Int) = (y:Int) => x+y
def add2a(x:Int)(y:Int) = x+y
			
println("def add2(x:Int) = (y:Int) => x+y")
println("add2(20)(30)")
	
println(add2(20)(30))

println("def add2a(x:Int)(y:Int) = x+y")
println("add2a(20)(30)")
println(add2a(20)(30))

println("--anonymous function--")
val add3 = (x:Int, y:Int) => x + y
println("val add3 = (x:Int, y:Int) => x + y")
println("add3(20,30)")
println(add3(20,30))


println("--Higher Order --")
println("def highorder1 (x:Double, y:Double, f:(Double, Double) => Double) : Double = f(x, y)")
def highorder1 (x:Double, y:Double, f:(Double, Double) => Double) : Double = f(x, y)

println("highorder1(50,20,(x,y) => x + y)")
println(highorder1(50,20,(x,y) => x + y))

println("highorder1(50,20,(x,y) => x - y)")
println(highorder1(50,20,(x,y) => x - y))

println("highorder1(50,20,(x,y) => x * y)")
println(highorder1(50,20,(x,y) => x * y))

println("highorder1(50,20,(x,y) => x / y)")
println(highorder1(50,20,(x,y) => x / y))

println("val highorder2 = (x:Double, y:Double, f:(Double, Double) => Double) => Double = f(x, y)")
val highorder2 = (x:Double, y:Double, f:(Double, Double) => Double) => f(x, y)

println("highorder2(50,20,(x,y) => x + y)")
println(highorder2(50,20,(x,y) => x + y))

println("highorder2(50,20,(x,y) => x - y)")
println(highorder2(50,20,(x,y) => x - y))

println("highorder2(50,20,(x,y) => x * y)")
println(highorder2(50,20,(x,y) => x * y))

println("highorder2(50,20,(x,y) => x / y)")
println(highorder2(50,20,(x,y) => x / y))


val highorder3 = (x:Double, y:Double, z:Double , f:(Double, Double) => Double) => f(f(x, y),z)  
println("highorder3(50,20,10,(x,y) => x + y)")
println(highorder3(50,20,10,(x,y) => x + y))

println("highorder3(50,20,10,_ + _")
println(highorder3(50,20,10, _ + _))

println("highorder3(50,20,10,_ * _")
println(highorder3(50,20,10, _ * _))


println("\n--partially applied functions --")
val sum = (a: Int, b:Int , c:Int) => a + b + c
val f = sum(10, 20, _:Int)
println("val sum = (a: Int, b:Int , c:Int) => a + b + c")
println("val f = sum(10, 20, _:Int)")
println("println(f(30))")
println(f(30))

import java.util.Date
val date = new Date

val log  = (date : Date, msg : String) => println(date +" : "+ msg)
val logit = log(date, _:String)
println("val log  = (date : Date, msg : String) => println(date + msg)")
println("val logit = log(date, _:String)")
println("""println(logit("this is a log message"))""")

println(logit("this is a log message"))


println("\n--closures: use variable defined outside the function--")

val number = 100
val addcls = (x:Int) => x + number

println(addcls(100))

println("partials with currying")

def addx(x:Int) = (y:Int) => x + y
val sump = addx(30)
println(sump(30))

def addy(x:Int)(y:Int) = x + y

val sumpx = addy(30)_
println(sumpx(40))



println("\n--String--")
println("Hello, New York!!!")

val str1="Hello"
val str2="World"

println(str1.concat(str2))
println(str1 + str2)

val num1 = 75
val num2 = 100.2323

val result = printf("%d|%f|%s", num1, num2, str1)
println(result)

println("%d|%f|%s".format(num1, num2, str1))
printf("%d|%f|%s", num1, num2, str1)



}