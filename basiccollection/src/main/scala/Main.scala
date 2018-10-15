object Main extends App {
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
//pp(map1.map(x => x*2))
pp(map1.mapValues(x => "hi " + x))

val mapHighOrder = (x : Int, y:Int, f:(Int,Int) => Int )  => f(x,y)

pp(ls1.map( x=> mapHighOrder(x,2,(_*_))))
pp(ls1.map( x=> mapHighOrder(x,2,(_+_))))
pp(ls1.map( x=> mapHighOrder(x,2,(_-_))))
pp(ls1.map( x=> mapHighOrder(x,x,(_*_))))


//String map
pp("hello to upper using map fucntion is :" +  "hello".map(_.toUpper))


pp("flatten") 
val ls2= List(4,5,6)

pp(List(ls1, ls2))
pp(List(ls1, ls2).flatten)

pp(List(ls1, ls2).flatten.map(_*2))
//pp(List(ls1, ls2).flatMap(x => x * 2))

pp(ls2.flatMap(x => List(x, x+1)))


val f:(Int) => Int  = (x) => x *2


 pp(ls1.map(_*2))
 pp(ls1.map(x => f(x)))
  pp(ls1.map(_ => f(_)))
 pp(ls1.map(f(_)))

 //filter

 pp(ls1.filter(_ > 2))



//Reduce, fold scan 

pp("Reduce ") 
println(ls1.reduceLeft( _ + _ ))
println(ls1.reduceLeft( (x,y) => {
	println(x + " + " + y)
	x + y
}))


pp("Fold")

println(ls1.foldLeft(100)(_ + _))

pp("Scan")
println(ls1.scanLeft(100)(_ + _))



}