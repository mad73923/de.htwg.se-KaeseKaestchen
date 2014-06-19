package de.htwg.se.kaesekaestchen.model;

public class Line implements ILine {
	
	private IPlayer theOwner;
	private IPoint startPoint;
	private Point endPoint;
	
	public Line(IPoint pStartPoint, Point pEndPoint){
		startPoint = pStartPoint;
		endPoint = pEndPoint;
		
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ILine#isOwnerNotSet()
	 */
	@Override
	public boolean isOwnerNotSet(){
		return theOwner == null;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ILine#setOwner(de.htwg.se.kaesekaestchen.model.Player)
	 */
	@Override
	public boolean setOwner(IPlayer newOwner){
		if(isOwnerNotSet()){
			theOwner = newOwner;
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ILine#getOwner()
	 */
	@Override
	public IPlayer getOwner(){
		return theOwner;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ILine#getLength()
	 */
	@Override
	public double getLength(){
		return startPoint.getDistanceToPoint(endPoint);
	}

}
