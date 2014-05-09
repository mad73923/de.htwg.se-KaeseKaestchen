package de.htwg.se.kaesekaestchen.model;

public class Point {
	
	private int valX;
	private int valY;
	
	public Point(int pX, int pY){
		valX = pX;
		valY = pY;
	}

	public int getValX() {
		return valX;
	}

	public void setValX(int valX) {
		this.valX = valX;
	}

	public int getValY() {
		return valY;
	}

	public void setValY(int valY) {
		this.valY = valY;
	}
	
	public boolean hasNegativeCoordinates(){
		if(this.valX<0 || this.valY<0){
			return true;
		}
		return false;
	}
	
	public double getDistanceToPoint(Point p){
		return Math.sqrt(Math.pow(this.valX-p.valX, 2) + Math.pow(this.valY-p.valY, 2));
	}
	
	public boolean isUnderPoint(Point reference){
		if(this.valY< reference.valY){
			return true;
		}
		return false;
	}
	
	public boolean isOverPoint(Point reference){
		if(this.valY> reference.valY){
			return true;
		}
		return false;
	}
	
	public boolean isLeftOfPoint(Point reference){
		if(this.valX<reference.valX){
			return true;
		}
		return false;
	}
	
	public boolean isRightOfPoint(Point reference){
		if(this.valX>reference.valX){
			return true;
		}
		return false;
	}
	
	public boolean hasSameXValueAs(Point reference){
		if(this.valX == reference.valX){
			return true;
		}
		return false;
	}
	
	public boolean hasSameYValueAs(Point reference){
		if(this.valY == reference.valY){
			return true;
		}
		return false;
	}
	
	
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
	
	@Override
	public int hashCode() {
		return Math.abs(this.valX)+Math.abs(this.valY);
	}

}
