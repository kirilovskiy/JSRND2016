package home.sixteenth.src.main.java.tractor.good;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tractor {

    int[] position = new int[] { 0, 0 };
    int[] field = new int[] { 5, 5 };
    Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if (command.equals("F")) { moveForwards();
        } else
        if (command.equals("T")) {
            setOrientation(turnClockwise());
        }
    }

    public void moveForwards() {
        position = choosePosition();
        if (getPositionX() > field[0] || getPositionY() > field[1]) {
            throw new TractorInDitchException();
        }
    }

    public Orientation turnClockwise() {
        if (orientation == Orientation.NORTH){return Orientation.EAST;}
        if (orientation == Orientation.EAST) {return Orientation.SOUTH;}
        if (orientation == Orientation.SOUTH) {return Orientation.WEST;}
        return Orientation.NORTH;
    }

    public int[] choosePosition(){
        if (getOrientation() == Orientation.NORTH) {return newPosition(getPositionX(), getPositionY() + 1);}
        if (getOrientation() == Orientation.EAST) {return newPosition(getPositionX()+1, getPositionY());}
        if (getOrientation() == Orientation.SOUTH) {return newPosition(getPositionX(), getPositionY() - 1);}
        return newPosition(getPositionX()-1, getPositionY());
    }

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
    }

    public int[] newPosition(int x, int y){
        return new int[]{x,y};
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public static void main(String[] args) throws IOException {
        Tractor tractor = new Tractor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("input command F or T");
            String command = reader.readLine();
            tractor.move(command);
        }
    }
}