
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        getToBeepers();
        getAndSortBeepers();
    }
    
    public void getAndSortBeepers() {
        int array[] = new int [8];
        int n=0;
        int k;
        int temp;
        int j=0;
        for(int i=0; i<8; i++) {
            while(frontIsClear()) {
                 pickBeeper();
                 move();
                 n++;
            }
            pickBeeper();
            n++;
            array[i]=n;
            reposition();
        }
        int i=0;
        for(int x=8; x>=0; x--) {
            for(int m=0; m<8-1; m++) {
                k=m+1;
                if(array[m]>array[k]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        getToStartingPosition();
        int y=0;
        for(int g=0; g<array[y]; g++) {
            putBeeper();
            move();
        }
        
            
          
        
    }
    
    public void getToBeepers() {
        while(!nextToABeeper()) {
            move();
        }
    }
    
    public void reposition() {
        turnLeft();
        move();
        turnLeft();
        while(nextToABeeper()) {
            move();
        }
        turnLeft();
        turnLeft();
        move();
    }
    
    public void repositionTwo() {
        turnRight();
        move();
        turnRight();
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        turnLeft();
    }
    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void getToStartingPosition() {
        turnRight();
        move();
        move();
        move();
        move();
        move();
        move();
        move();
        move();
        turnRight();
    }
   
}

