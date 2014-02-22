package snipe;

import java.util.Observable;

/**
 * A ball model
 * 
 * @author Hangfei Lin and Chih-Chung Huang
 * @version April 18, 2013
 */
class Model extends Observable {
	static int defaultWindowSizeW = 800;
    static int defaultWindowSizeH = 800;
    
	int minimum = 0;
	int maximum = 16;
	int maximumPosition = defaultWindowSizeW;
	//not exclude 0 now !!!

	public Ball ballUserControl = new Ball(defaultWindowSizeW/2, defaultWindowSizeH/2, 0, 0, 0, 0, 0);
	//set a different initial positions
	
	final int ballNumber = 7;
	public Ball[] ballArray = new Ball[ballNumber];
	public boolean gameStatus = false;

		
	 /**
     * Make a step forward of all balls
     */
    public void makeOneStep() {
    	//Do the work
    	ballUserControl.makeOneStepBackEdge();
    	
    	for(int i = 0; i < ballNumber; i++) {
    		ballArray[i].makeOneStepOverEdge();
    	}
        // Notify observers
        setChanged();
        notifyObservers();
    }
	
    
    /*
     * Generate the initial balls with randomed speed and position
     */
	public void generateComputerBalls() {
		for(int i = 0; i < ballNumber ; i++) {
			int xRandomNumDelta = minimum + (int)(Math.random()*maximum) - 8; 
			int yRandomNumDelta = minimum + (int)(Math.random()*maximum) - 8; 
			int xRandomNumPosition = minimum + (int)(Math.random()*maximumPosition); 
			int yRandomNumPosition = minimum + (int)(Math.random()*maximumPosition); 
			int rRandomColor = 0 + (int)(Math.random()*255); 
			int gRandomColor = 0 + (int)(Math.random()*255); 
			int bRandomColor = 0 + (int)(Math.random()*255);
			int totalColor = rRandomColor + gRandomColor + bRandomColor;
			
			//Check if speed in both direction are zero
			if( xRandomNumDelta == 0 && yRandomNumDelta == 0) {
				if(totalColor < 10 || totalColor > 740) { //740 < 255*3
					rRandomColor = 30 + (int)(Math.random() * 230); 
					gRandomColor = 30 + (int)(Math.random() * 230); 
					bRandomColor = 30 + (int)(Math.random() * 230);
					ballArray[i] = new Ball(xRandomNumPosition, yRandomNumPosition, xRandomNumDelta+1, 
							yRandomNumDelta+1, rRandomColor, gRandomColor, bRandomColor);
				}
				else {
					ballArray[i] = new Ball(xRandomNumPosition, yRandomNumPosition, xRandomNumDelta+1, 
							yRandomNumDelta+1, rRandomColor, gRandomColor, bRandomColor);
				}
			}
			else {
				if(totalColor < 100 || totalColor > 640) { //740 < 255*3
					rRandomColor = 30 + (int)(Math.random() * 230); 
					gRandomColor = 30 + (int)(Math.random() * 230); 
					bRandomColor = 30 + (int)(Math.random() * 230);
					ballArray[i] = new Ball(xRandomNumPosition, yRandomNumPosition, xRandomNumDelta+1, 
							yRandomNumDelta+1, rRandomColor, gRandomColor, bRandomColor);
				}
				else {
					ballArray[i] = new Ball(xRandomNumPosition, yRandomNumPosition, xRandomNumDelta+1, 
							yRandomNumDelta+1, rRandomColor, gRandomColor, bRandomColor);
				}
			}
		}//end of for loop
	}
	
	/**
	 */
	public void resetBalls() {
		for(int i = 0; i < ballNumber; i++) {
			ballArray[i] = new Ball();
		}
		//the below one would not initialization?
		//ballArray = new Ball[ballNumber];
		ballUserControl = new Ball(defaultWindowSizeW/2, defaultWindowSizeH/2, 0, 0, 0, 0, 0);
		//generateComputerBalls();
	}
	
	/*
	 * Set the position limits of the balls
	 */
	public void setLimits(int width, int height) {
		ballUserControl.setLimits(width, height);
		for( int i = 0; i < ballNumber; i++) {
			ballArray[i].setLimits(width, height);
		}
	}
    
    /**
     * Judge if balls collide
     * 
     */
    public boolean judgeCollision(Ball ballA, Ball ballB){
    	//ballUserControl
    	int ballToBallDistance = (int) (ballA.BALL_SIZE + ballB.BALL_SIZE) / 2;
    	if(getDistance(ballA, ballB) < ballToBallDistance ) {
    		//System.out.println("Test33");
    		return true;
    	}
    	else return false;
    }//end of judgeCollision method
    
    /**
     * distance
     */
    public double getDistance(Ball ballA, Ball ballB) {
    	double ballDistance;
    	double squareDist;
    	squareDist = (Math.pow(ballA.getX()-ballB.getX(), 2))
    			+ (Math.pow(ballA.getY()-ballB.getY(), 2));
    			
    	ballDistance = Math.sqrt(squareDist);
    	return ballDistance;
    }
    
    /**
     * stops the ball if collision happen
     * several balls?
     */
    public void collideAndStop() {
    	for(int i = 0; i < ballNumber; i++) {
    		if(judgeCollision(ballUserControl, ballArray[i])) {
    			ballArray[i].setStationary();
        	}
    	}
    }
    
    /**
     * modify the color according to the collision and so on
     */
    public void ballColors() {
    	for(int i = 0; i < ballNumber; i++) {
    		if(ballArray[i].isStationary()) {
    			ballArray[i].fadeColor();
        	}
    	}
    }
    
    /**
     *tell whether all the balls are dead
     *
     */
    public boolean ballsAllDead() {
    	for(int i = 0; i < ballNumber; i++) {
    		if( !ballArray[i].isDead) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * tells whether the game starts
     */
    public boolean gameStatus() {
    	return gameStatus;
    }
    
    /**
     * start the game
     * 
     */
    public void gameStatusStart() {
    	gameStatus = true;
    }
    
    /**
     * stop(quit) the game
     * 
     */
    public void gameStatusQuit() {
    	gameStatus = false;
    }
    

    
}//end of the Model class