package PageReplacementAlgorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class FIFO extends ReplacementAlgorithm{

    /**
     * @param pageFrameCount - the number of physical page frames
     */
    public FIFO(int pageFrameCount) {
        super(pageFrameCount, "FIFO");

    }

    /**
     * @param pageNumber - the page number to be inserted
     */
    @Override
    public void insert(int pageNumber) {
        //is it in the frame?
        if (!super.frame.contains(pageNumber)) {
            //is the Frame full?
            super.pageFaultCount++;
            print(pageNumber  + " was miss #: " + super.pageFaultCount);
            if (super.isFull()) {
                //we have no more frames

                //get the next off the queue
                Integer victim = super.frame.removeFirst();
                super.print("removed " + victim + " from the frame list, add " + pageNumber );
                super.frame.add(pageNumber);


            }else{
                //the frame was not full yeah
                super.frame.add(pageNumber);

            }

        }else{
            print("Number " + pageNumber + ", this was a hit!");
            //print the current frame.
        }
        super.print(super.frame.toString());

    }

}




