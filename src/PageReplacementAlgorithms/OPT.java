package PageReplacementAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class OPT extends ReplacementAlgorithm{

   private int startIndex;

    private int [] numArray;
    /**
     * @param pageFrameCount - the number of physical page frames
     */
    public OPT(int pageFrameCount, int [] numArray) {
        super(pageFrameCount, "OPT");
        this.numArray = numArray;
        this.startIndex = 0;
    }

    /**
     * @param pageNumber - the page number to be inserted
     */
    @Override
    public void insert(int pageNumber) {
        if(!frame.contains(pageNumber)){
            pageFaultCount++;
            if(isFull()){
                //no frames left :(
                //find the frame to replace
                int victim = getNextRemove();
                frame.remove(Integer.valueOf(victim));
                frame.add(pageNumber);
                print(victim + " Was removed to make room for " + pageNumber);
            }else{
                frame.add(pageNumber);
                print(pageNumber + " was a miss, added to the frame list");
            }

        }else{
            print(pageNumber + " was a hit ");
            //do nothing esle
        }
        startIndex++;
    }

    /**
     * this method will tell the future and return the number we should make our victim
     * @return a integer number that will be our victim.
     */
    public int getNextRemove(){

        //get a number and then iterate through the frame until you find the next instance of that number.
        ArrayList<Integer> temp= new ArrayList<>(frame);
        int count = pageFrameCount;
        int farRight = -1;
        for(int i = startIndex + 1; i < numArray.length; i++){
            if(!temp.isEmpty() && temp.contains(numArray[i])){
                temp.remove(Integer.valueOf(numArray[i]));
                farRight = numArray[i];
            }
        }
        if(temp.isEmpty()){
            return farRight;
        }else{
            return temp.remove(0);
        }
    }
}
