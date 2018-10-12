
object Main extends App {


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

println("\n--Arrays--")

val ar = new Array[Int](4)

ar(0) = 20
ar(1) = 21
ar(2) = 22
ar(3) = 23

ar(0) = 99

for(x <- ar)
	println(x)


println("\n--List--")

val ls = List(1,2,3,4,5,5)
val lsnames = List("a","b","c")


println(ls)
println(lsnames)

println("cons")

println(0::ls)
println(1::10::10::Nil)

println(ls.head)
println(ls.tail)
println(ls.isEmpty)
println(ls.reverse)
println(List.fill(5)(22))

for(s <-ls)
		println(s)

ls.foreach(println(_)	)


println("\n--Sets--")

val myset:Set[Int] = Set(1,2,3,4,5)
println(myset)
println(ls.toSet)

println("\n--mutable Sets--")

//var myset2 = scala.collection.mutable.Set(10, 11, 12, 13)
//myset2 ++ new scala.collection.mutable.Set( 99)
//println(myset2)


println("\n--Maps--")

val mymap: Map[Int, String] = Map(1 -> "Odin", 2->"Lucy", 3-> "John")

println(mymap)
println(mymap(1))
println(mymap.keys)
println(mymap.values)
println(mymap.isEmpty)

for (i <- mymap.keys)
		println(mymap(i))


val mymap2: Map[Int, String] = Map(4 -> "Odin", 5->"Lucy", 6-> "John")


println(mymap ++ mymap2)


println("\n--Tuples--")

val mytuple3 =  (1, 2.1, "hello", true)

val mytuple2 =  (1, 2.1, "hello", false)

println(mytuple2)

mytuple3.productIterator.foreach( i => println(i))
//println(mytuple3.productIterator ++ mytuple2.productIterator)


println("\n--Options--")

val ls1 = List(1,2,3)
val map1 = Map(1->"Jonn", 2->"Lucy", 3 -> "Odin")
val opt: Option[Int] = Some(99)
println(ls1.find(_ > 4)) //None

println(ls1.find(_ > 1).get ) //find 1st element > 1
println(ls1.find(_ > 4).getOrElse(0) ) //find 1st element > 0 ; 0

println(map1.get(5).getOrElse("ekk"))
println(opt.isEmpty)

val pp = (o: Object) => println(o)

pp("\n--map and filter")


pp(ls1.map(_*2))
pp(ls1.map(x => x*2))


val mapHighOrder = (x : Int, y:Int, f:(Int,Int) => Int )  => f(x,y)

pp(ls1.map( x=> mapHighOrder(x,2,(_*_))))

}