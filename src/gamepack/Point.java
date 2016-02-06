package gamepack;

/**
 * This class will be used to make points.
 * 
 * @author Bart and Jacob
 *
 */
public class Point {
	
	// The x and y coordinates of the Point 
	int x;
	int y;
	
	public Point( int x, int y ){
		this.x = x;
		this.y = y;
	}
	
	public Point(){
		this( 0, 0 );
	}
	
	public void setPoint( int x, int y ){
		setX( x );
		setY( y );
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX( int x ){
		this.x = x;
	}
	
	public void setY( int y ){
		this.y = y;
	}
	
}
