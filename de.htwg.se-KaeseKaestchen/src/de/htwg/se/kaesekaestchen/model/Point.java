package de.htwg.se.kaesekaestchen.model;

public class Point implements IPoint {
	
	private int valX;
	private int valY;
	
	public Point(int pX, int pY){
		valX = pX;
		valY = pY;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#getValX()
	 */
	@Override
	public int getValX() {
		return valX;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#setValX(int)
	 */
	@Override
	public void setValX(int valX) {
		this.valX = valX;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#getValY()
	 */
	@Override
	public int getValY() {
		return valY;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#setValY(int)
	 */
	@Override
	public void setValY(int valY) {
		this.valY = valY;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#hasNegativeCoordinates()
	 */
	@Override
	public boolean hasNegativeCoordinates(){
		if(this.valX<0 || this.valY<0){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#getDistanceToPoint(de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public double getDistanceToPoint(Point p){
		return Math.sqrt(Math.pow(this.valX-p.valX, 2) + Math.pow(this.valY-p.valY, 2));
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#isUnderPoint(de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public boolean isUnderPoint(Point reference){
		if(this.valY< reference.valY){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#isOverPoint(de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public boolean isOverPoint(Point reference){
		if(this.valY> reference.valY){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#isLeftOfPoint(de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public boolean isLeftOfPoint(Point reference){
		if(this.valX<reference.valX){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#isRightOfPoint(de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public boolean isRightOfPoint(Point reference){
		if(this.valX>reference.valX){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#hasSameXValueAs(de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public boolean hasSameXValueAs(Point reference){
		if(this.valX == reference.valX){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#hasSameYValueAs(de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public boolean hasSameYValueAs(Point reference){
		if(this.valY == reference.valY){
			return true;
		}
		return false;
	}
	

	
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj.getClass().equals(this.getClass())){
			Point pPoint = (Point) obj;
			if(this.valX==pPoint.valX && this.valY==pPoint.valY){
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPoint#hashCode()
	 */
	@Override
	public int hashCode() {
		return Math.abs(this.valX)+Math.abs(this.valY);
	}

}
