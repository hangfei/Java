package snipe;

//import java.awt.Color;

/**
 * A ball maker
 * 
 * @author Hangfei Lin and Chih-Chung Huang
 * @version April 18, 2013
 */
public class Ball {
    public final int BALL_SIZE = 100;
    private int xPosition = 0;
    private int yPosition = 0;
    final private int fadingRate = 5;
    private int xLimit, yLimit;
    private int xDelta = 0;
    private int yDelta = 0;
    boolean isStationary = false;
    boolean isDead = false;
    //set default color to blue and green
    int ballColorR = 255;
    int ballColorG = 0;
    int ballColorB = 0;
    final int speedLimit = 30;
    //when a ball passes the edge, the animation should be tuned to look more naturally
    final int overEdgeAnimation = 2; 
    
    
    public Ball() {
    	xPosition = 0;
    	yPosition = 0;
    	xDelta = 0;
    	yDelta = 0;
    	isStationary = false;
        isDead = false;
        ballColorR = 255;
        ballColorG = 0;
        ballColorB = 0;
    }
    
    /*
     * set the initial positions of the ball
     * constructor
     * @param x
     * @param y
     * @param xDelta
     * @param yDelta
     * @param ballColorR
     * @param ballColorG
     * @param ballColorB
     */
    public Ball(int x, int y, int xDelta, int yDelta, int ballColorR, int ballColorG, int ballColorB) {
    	xPosition = x;
    	yPosition = y;
    	this.xDelta = xDelta;
    	this.yDelta = yDelta;
    	this.ballColorR = ballColorR;
        this.ballColorG = ballColorG;
        this.ballColorB = ballColorB; 
    }
    
//    /**
//     * set the initial color of the ball
//     * @param i
//     * @param j
//     * @param k
//     */
//    public Ball(int ballColorR, int ballColorG, int ballColorB) {
//    	//TO-DO set the color of the ball
//    	if(ballColorR <= 255 && ballColorR >= 0 
//    			&& ballColorG <= 255 && ballColorG >= 0 
//    			&& ballColorB <= 255 && ballColorB >= 0) {
//    	this.ballColorR = ballColorR;
//        this.ballColorG = ballColorG;
//        this.ballColorB = ballColorB; 
//    	}
//        else {
//        	System.out.println("Color Error!" + ballColorR + ballColorG + ballColorB);
//        }
//    	
//    }
    
    /**
     * Set the bounds of the ball 
     * according to the screen or somewhere else
     * @param xLimit The screen size limitation in x direction
     * @param yLimit The screen size limitation in y direction
     */
    public void setLimits(int xLimit, int yLimit) {
        this.xLimit = xLimit - BALL_SIZE;
        this.yLimit = yLimit - BALL_SIZE;
    }

    /**
     * Get the x position of the ball
     * @return
     */
    public int getX() {
        return xPosition;
    }

    /**
     * Get the y position of the ball
     * @return
     */
    public int getY() {
        return yPosition;
    }
    
    /**
     * Determine the movement of the user ball
     * 
     */
    public void makeOneStepBackEdge() {
        // Changes the position of the ball
        xPosition += xDelta;
        if (xPosition < 0 || xPosition >= xLimit) {
            xDelta = -xDelta;
            xPosition += xDelta;
        }
        yPosition += yDelta;
        if (yPosition < 0 || yPosition >= yLimit) {
            yDelta = -yDelta;
            yPosition += yDelta;
        }
    }
    
    /**
     * Determine the movement of the free ball
     * 
     */
    public void makeOneStepOverEdge() {
        // Changes the position of the ball
        xPosition += xDelta;
        if (xPosition < -BALL_SIZE - overEdgeAnimation ) {
            xPosition = xLimit;
        }
        else if( xPosition > xLimit + BALL_SIZE + overEdgeAnimation) {
        	xPosition = 0;
        }
        yPosition += yDelta;

        if (yPosition < -BALL_SIZE - overEdgeAnimation ) {
            yPosition = yLimit;
        }
        else if( yPosition > yLimit + BALL_SIZE+overEdgeAnimation) {
        	yPosition = 0;
        }
    }
    
    /**
     * Change the speed of the free ball
     * @param x
     * @param y
     */
    public void changeSpeed(int x, int y) {
    	//better to filter the input
    	if ( Math.abs(x) <= 1 && Math.abs(y) <= 1) {
    		if( x > 0) {
    			if( xDelta < speedLimit) {
        			xDelta = xDelta + x;
        		}
    		}
 
    		if( x < 0) {
    			if( xDelta > -speedLimit) {
        			xDelta = xDelta + x;
        			
        		}
    		}
    		
    		if( y > 0) {
    			if( yDelta < speedLimit) {
        			yDelta = yDelta + y;
        		}
    		}
    	
    		if( y < 0) {
    			if( yDelta > -speedLimit) {
        			yDelta = yDelta + y;
        			
        		}
    		}
    	}//end of first if    	

    }//end of changeSpeed method
    
    /**
     * sets the ball stationary
     * if it's collided with the user control ball
     * xDelta = 0
     * yDelta = 0
     */
    public void setStationary() {
    	xDelta = 0;
    	yDelta = 0;
    	isStationary = true;
    }
    
    /**
     * Check if the ball has been hit and is stationary
     * 
     */
    public boolean isStationary() {
    	//XXX
    	return isStationary;
    }
    
    
    /**
     * Check if the ball has been dead(stationary and color fade to white)
     * when a ball died, computations should ignore this ball
     * before each computation, better to judege the ball's status
     */
    public boolean isDead() {
    	return isDead;
    }
    
    /**
     * Fade the color of the ball
     * Set ball to dead if all color is 255.
     */
    public void fadeColor() {
    	//XXX
    	//Hang fei use <250 why??
    	if((ballColorR + fadingRate) < 255 && (ballColorR + fadingRate) > 0) {
    		ballColorR = ballColorR + fadingRate;
    	}
    	else ballColorR = 255;
    	
    	if((ballColorG + fadingRate) < 255 && (ballColorG + fadingRate) > 0) {
    		ballColorG = ballColorG + fadingRate;
    	}
    	else ballColorG = 255;
    	
    	if((ballColorB + fadingRate) < 255 && (ballColorB + fadingRate) > 0) {
    		ballColorB = ballColorB + fadingRate;
    	}
    	else ballColorB = 255;
    	
    	if(ballColorR == 255 && ballColorG == 255 && ballColorB == 255) {
    		isDead = true;
    	}
    }

}//end of the Ball calss