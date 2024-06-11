package PageReplacementAlgorithms;

import java.util.ArrayList;

public abstract class ReplacementAlgorithm {
    // the number of page faults
    protected int pageFaultCount;
    protected ArrayList<Integer> frame;
    protected String name;

    // the number of physical page frames
    protected int pageFrameCount;

    // use for printing actions
    protected boolean printOn;
    //keep crated the number of used frames
    protected int frameCount;

    /**
     * @param pageFrameCount - the number of physical page frames
     */
    public ReplacementAlgorithm(int pageFrameCount, String name) {
        if (pageFrameCount < 0)
            throw new IllegalArgumentException();

        this.pageFrameCount = pageFrameCount;
        this.frame = new ArrayList<>();
        pageFaultCount = 0;
        this.printOn = false;
        this.frameCount = 0;
        this.name = name;

    }

    /**
     * @return - the number of page faults that occurred.
     */
    public int getPageFaultCount() {
        return pageFaultCount;
    }
    /**
     * @param pageNumber - the page number to be inserted
     */
    public abstract void insert(int pageNumber);

    public void print(String s){
        if(printOn){
            System.out.println(s);
        }
    }

    /**
     * A boolean to see if a frame was a miss or not.
     * @return true if the frame is full, false if there is room.
     */
    public boolean isFull(){
        frameCount++;
        return (frameCount <= pageFrameCount) ? false : true;
    }

    /**
     * Return the name of the algorithm doing the counting.
     * @return the name of the algorithm in string format..
     */
    public String getName(){
        return name;
    };
}
