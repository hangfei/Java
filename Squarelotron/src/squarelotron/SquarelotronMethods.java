package squarelotron;

public interface SquarelotronMethods {
    public int[] numbers();
    public Squarelotron upsideDownFlip(String ring);
    public Squarelotron leftRightFlip(String ring);
    public Squarelotron inverseDiagonalFlip(String ring);
    public Squarelotron mainDiagonalFlip(String ring);
    public Squarelotron sideFlip(String side);
    public void rotateRight(int numberOfTurns);
    @Override public boolean equals(Object object);
    @Override public String toString();
}