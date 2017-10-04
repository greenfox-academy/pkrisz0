import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {
    int posX;
    int posY;
    int boardSide;
    Map map;
    Hero hero;
    Skeleton skeletonOne;
    Skeleton skeletonTwo;
    Skeleton skeletonThree;
    Boss boss;

    public Board() {
        posX = 0;
        posY = 0;
        boardSide = 720;

        map = new Map();
        hero = new Hero("", posX,posY);

        skeletonOne = new Skeleton("", randomCoordinate()[1],randomCoordinate()[0]);
        skeletonTwo = new Skeleton("", randomCoordinate()[1],randomCoordinate()[0]);
        skeletonThree = new Skeleton("", randomCoordinate()[1],randomCoordinate()[0]);

        boss = new Boss("", randomCoordinate()[1],randomCoordinate()[0]); // *here comes the new boss, same as the old boss*

        // set the size of your draw board
        setPreferredSize(new Dimension(boardSide, boardSide));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {

        //draw board with walls
        for (int j = 0; j < map.walls.length; j++) {
            for (int i = 0; i <  map.walls.length; i++) {
                if ( map.walls[j][i] == 1) {
                    PositionedImage wall = new PositionedImage("C:/greenfox/pkrisz0/week-05/day-02/Images/wall.png",i,j);
                    wall.draw(graphics);
                } else if ( map.walls[j][i] == 0) {
                    PositionedImage background = new PositionedImage("C:/greenfox/pkrisz0/week-05/day-02/Images/floor.png", i, j);
                    background.draw(graphics);
                }
            }
        }
        hero.draw(graphics);

        skeletonOne.draw(graphics);
        skeletonTwo.draw(graphics);
        skeletonThree.draw(graphics);


        boss.draw(graphics);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RPG Game");
        Board board = new Board();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.addKeyListener(board);
    }

    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    // But actually we can use just this one for our goals here
    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
        if (e.getKeyCode() == KeyEvent.VK_UP && hero.stayIn("y-1")) {
            hero.posY--;
            hero.turn("up");
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN && hero.stayIn("y+1")) {
            hero.posY++;
            hero.turn("down");
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT && hero.stayIn("x-1")) {
            hero.posX--;
            hero.turn("left");
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT && hero.stayIn("x+1")) {
            hero.posX++;
            hero.turn("right");
        }
        // and redraw to have a new picture with the new coordinates
        repaint();
    }

    public int random(){
        return (int) Math.floor(Math.random() * 10);
    }

    public int[] randomCoordinate(){
        int[] output = new int[2];
        output[0] = 4;
        output[1] = 0;
        while (map.isItAWall(output[0], output[1])){
            output[0] = random();
            output[1] = random();
        }
        return output;
    }
}

