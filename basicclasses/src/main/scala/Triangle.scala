package inheritance
class Triangle(w : Double, h : Double)  extends Polygon with Shape
{
	override val area:Double = { w * h / 2 }
	override val color: String = "Red"
	}