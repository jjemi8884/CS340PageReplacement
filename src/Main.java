import PageReplacementAlgorithms.FIFO;
import PageReplacementAlgorithms.LRU;
import PageReplacementAlgorithms.OPT;
import PageReplacementAlgorithms.ReplacementAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<int []> algoTest = InitTest();
        algoTest.add(randomTest());
        int [] frameArray = new int []{3, 5, 7};
        algorithmTest(algoTest, frameArray);


    }

    /**
     * O(1)
     * create a random array of integer length 20
     * @return a length 20 random array of integers 0 to 9 inclusive
     */
    public static int [] randomTest(){
        Random rand = new Random();
        int numMemsToTest = 20;
        int [] list1 = new int[numMemsToTest];
        for(int i = 0; i < numMemsToTest; i++){
            list1[i] = rand.nextInt(10);
        }
        return list1;
    }

    /**
     * O(N)
     * a tst to check my algorithms
     */
    public static void algorithmTest(ArrayList<int[]> initTest, int[] frameArray) {


        int count = 1;
        int lineLength = 60;
        for (int[] list : initTest) {
            int length = list.length;
            for (int frames : frameArray) {
                ReplacementAlgorithm fifo = new FIFO(frames);
                printList(list);
                for (int i = 0; i < list.length; i++) {
                    fifo.insert(list[i]);
                }
                printResult(fifo, count, frames,length );

                ReplacementAlgorithm lru = new LRU(frames);
                for (int j = 0; j < list.length; j++) {
                    lru.insert(list[j]);
                }
                printResult(lru, count, frames, length);

                ReplacementAlgorithm opt = new OPT(frames, list);
                for (int j = 0; j < list.length; j++) {
                    opt.insert(list[j]);
                }
                printResult(opt, count, frames, length);
                printline("-", lineLength);
                count++;
            }
        }
    }

    public static void printList(int [] list){
        System.out.print(" Pages requested : [" + list[1]);
        for(int i = 1; i < list.length; i++){
            System.out.print(", " + list[i]);
        }
        System.out.println("]");
    }

    /**
     * Make it easy to print a line
     * @param s is the string to print
     * @param length how lone to print
     */
    public static void printline(String s, int length){
        for(int i = 0; i < length; i++){
            System.out.print(s);
        }
        System.out.println();
    }

    /**
     * O(1)
     * method to clean the output in a standard way
     * @param r is the algorithm to be printed
     */
    public static void printResult(ReplacementAlgorithm r , int count, int frames, int numFrames){
        double faultRate = (double)r.getPageFaultCount()/(double)numFrames * 100;
        double hitRate = ((double)numFrames - (double)r.getPageFaultCount()) / (double)numFrames * 100;
        System.out.printf("The algorithm %4s error count was %3d for list number " +
                        "%2d with %2d frames resulting in %2.0f%% fault Rate and %2.0f%% hit rate\n",
                r.getName(), r.getPageFaultCount(), count, frames,faultRate,hitRate);
    }

    /**
     * O(1)
     * This method creates a list of integer arrays that are pregiven by the assignment.
     * @return ArrayList of integers that have been already created by the assignment.
     */
    public static ArrayList<int []> InitTest(){
        int [] l1 = new int[]{ 7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        int [] l2 = new int[]{ 8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
        int [] l3 = new int[]{ 4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
        ArrayList<int []> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        return list;
    }
}