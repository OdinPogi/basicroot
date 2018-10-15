package inheritance
class Triangle(w : Double, h : Double)  extends Polygon
{
	override val area:Double = { w * h / 2 }
	}