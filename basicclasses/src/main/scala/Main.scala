//constructor declaration
//var getter  setter
//val getter   ---
//default     ----		----
//private - must create method to access



class User(private var name:String, var age:Int){
	val printName =  { println(name) }
}
//Auxcillary constructor
class User2(var name:String, var age:Int){
	def this(){
		this("Odin", 7)
	}

	def this(name : String){
		this(name, 7)
	}


}

object Main extends App {
  println("classes: blueprint for creating object")

  var user = new User("Odin", 7)

user.printName
println(user.age)

var user2 = new User2("Lucy", 11)
var user3 = new User2()
var user4 = new User2("John")

println(user2.name)
println(user3.name)
println(user4.name)


}