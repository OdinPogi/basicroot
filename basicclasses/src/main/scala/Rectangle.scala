package inheritance
class Rectangle(w : Double, h : Double) extends Polygon
{
	override val area: Double = { w * h }
}

	