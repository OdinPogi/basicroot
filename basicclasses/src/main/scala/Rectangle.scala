package inheritance
class Rectangle(w : Double, h : Double) extends Polygon with Shape
{
	override val area: Double = { w * h }
	override val color: String = "Blue"

}


	