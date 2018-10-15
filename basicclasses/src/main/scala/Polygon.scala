package inheritance
class Polygon
{
	def area : Double = 0.0;
}


object Polygon{
	def main(args : Array[String]){
		var poly = new Polygon;
		printAreaIm(poly)
		printAreaEx(poly)

		val rect = new Rectangle(12.5, 5.5)

		printAreaIm(rect)
		printAreaEx(rect)

			val tri = new Triangle(12.5, 5.5)

		printAreaIm(tri)
		printAreaEx(tri)
	}

val printAreaIm = (p:Polygon) => {println(p.area)}
val printAreaEx : (Polygon) => Unit  = (p) => {println(p.area)}



}