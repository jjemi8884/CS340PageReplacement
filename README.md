# RESULTS of the Page replacement 

## best preforming
As expected, the optimal paging process was the best preforming all paging algorithms. 
Least Recently was sometimes in a close runner-up to the optimal algorithim, and as expected, 
FIFO brought up the rear of the three algorithms. 

Another observation is when the page count increases, the FIFO would decrease its hit rate to match the optimal
solution.This is due to having more space to allow for a better chance of having the correct page in the queue.

It was noted that for the random test, the hit rate for the optimal solution seems to drop to a lower percentage.
As a certian point, if the number of pages is high enough, the algorithm for selecting pages does not really matter
the FIFO solution will perform just as well as the Optimal. I suspect this is also the case with high page request
and more pages spaces.

## The run time for the algorithm is:

## FIFO: O(n) where n is the number of pages request
Since we are using a queue to hold the pages, we remove the first element which is a O(1). Any new page added would be 
added at the end of the queue.

## LRU: O(n) Worst O(n^2)
This is a O(n) with the use of hashmap or hashset to store the elements. The time comes from having to first see if the 
the page is in the queue, then iterate back thought the elements looking to for the last element in the list. This 
could make O(N^2) if we are extremely unlucky and have to run back through the list every time to find the 
LRU

## OPT: O(n) Worst O(n^2)
This is practically the same algorithm as the LRU, except in the other direction. Looking up the page using a hash is the 
quickest way to identify the page, but looking for the farthest page in the future that will be used has the same problems  
and looking behind. If unluckily, then each page is only used once, and we have to iterate the pages all the way to the 
end every time. The payoff of looking for the last time a page was, or when the next time a page will, be used
is much more cost prohibitive vs using just the plan old FIFO. But in dealing with big numbers and every small advantage will
 benefit in the grand scheme. But as is the case, the most optimal solution is just a baseline and cannot be 
 used in a real computer since we cannot see into the future.


