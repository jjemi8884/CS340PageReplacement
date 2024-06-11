package PageReplacementAlgorithms;

import javax.xml.xpath.XPath;

public class LRU extends ReplacementAlgorithm{

    /**
     * @param pageFrameCount - the number of physical page frames
     */
    public LRU(int pageFrameCount) {
        super(pageFrameCount, "LRU");
    }

    /**
     * @param pageNumber - the page number to be inserted
     */
    @Override
    public void insert(int pageNumber) {
        if(!frame.contains(pageNumber)){
            pageFaultCount++;
            if(isFull()){
                //find the oldest used frame.
                int victim = frame.removeLast();
                print("Miss, removed " + victim + ", added " + pageNumber + " miss # " + pageFaultCount);
                frame.addFirst(pageNumber);
            }else{
                print("Miss, frame was open added " + pageNumber);
                frame.addFirst(pageNumber);
            }
        }else{
            print(pageNumber + " was a hit," + pageNumber+ " moving to top of stack");
            if(!frame.isEmpty()) {
                frame.remove(Integer.valueOf(pageNumber));
            }
            frame.addFirst(pageNumber);
        }
        print(frame.toString());
    }
}
