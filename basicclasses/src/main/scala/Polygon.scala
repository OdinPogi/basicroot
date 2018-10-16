package inheritance
class Polygon
{
	def area : Double = 0.0;
}

abstract class AbstractPolygon
{
	def area : Double;
}


//traits : partialy implemented interface
//at least one method is bastract
trait  Shape
{
	def area : Double;
	def color : String;

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

object AbstractPolygon{
	def main(args : Array[String]){
		val rect = new Rectangle(12.5, 5.5)

		printAreaIm(rect)
		printAreaEx(rect)
		println(rect.color)

			val tri = new Triangle(12.5, 5.5)

		printAreaIm(tri)
		printAreaEx(tri)
		println(tri.color)
	}

val printAreaIm = (p:Polygon) => {println(p.area)}
val printAreaEx : (Polygon) => Unit  = (p) => {println(p.area)}



}