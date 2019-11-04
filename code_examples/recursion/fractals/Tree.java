package lecture03.fractals;
//code courtesy of Craig Kapp


import processing.core.PApplet;

@SuppressWarnings("serial")
public class Tree  extends PApplet
{
	// include an angle variable instead of hard coding this value
	float angle = radians(45);
	
	public void setup()
	{
		// set up our canvas
		size(600,600);
		smooth();
		background(255);
		
		// draw the original branch
		pushMatrix();
		translate(300,600);
		drawBranch(180, 20);
		popMatrix();
	}
	
	// draw method - infinite loop
	public void draw()
	{
		// continually draw new branches if the mouse is pressed
		if (this.mousePressed)
		{
			this.angle = radians( random(20,120) );
			background(255);
			pushMatrix();
			translate(300,600);
			drawBranch(180, 20);
			popMatrix();
		}
	}
	
	public void drawBranch(float length, float thickness)
	{
		// set our thickness
		strokeWeight(thickness);
		
		// draw a simple branch at our current origin point
		line(0,0, 0,0-length);
		
		// if our branch is sufficiently large then we should branch again!
		if (length > 15)
		{
			// move the origin to the end of this branch
			translate(0, 0-length);
			
			// compute a new length
			float newLength = (float) (length * 0.66);
			
			// compute a new thickness
			float newThickness = (float) (thickness * 0.5);
			
			// draw a branch on the left
			// to do this we need to rotate the canvas a little bit
			// to rotate in PApplet we need to (a) tell Java to remember
			// the current rotation, (b) rotate & draw, and (c) restore our
			// current rotation
			pushMatrix();
			rotate( this.angle );
			drawBranch(newLength, newThickness);
			popMatrix();
			
			// do the same for the right branch
			pushMatrix();
			rotate( -1*this.angle );
			drawBranch(newLength, newThickness);
			popMatrix();
			
			
		}
	}
}

