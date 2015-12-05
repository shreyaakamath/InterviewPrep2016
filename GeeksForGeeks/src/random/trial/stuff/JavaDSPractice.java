package random.trial.stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class JavaDSPractice {

	public static void main(String[] args) {
		//normal min pririoty queue 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(10);
		pq.add(9);
		
		/*iterate over queue-> 5 ways Ref: http://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/
		 * 1)normal for loop
		 * 2)for(int n: pq)...
		 * 3)using an iterator
		 */
		
		Iterator<Integer> it = pq.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		//max priority queue
		PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(10,Collections.reverseOrder());
		pqMax.add(9);
		pqMax.add(10);
		Iterator<Integer> it1 = pqMax.iterator();
		System.out.println();
//		while(it1.hasNext()){
//			System.out.println(it1.next());
//		}
		
		/*Java list copy - need to independent lists with same content*/
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);l1.add(2);l1.add(3);l1.add(4);
		Iterator<Integer> itList = l1.iterator();
		while(itList.hasNext()) System.out.println(itList.next());
		
		List<Integer> l2 = new ArrayList<Integer>(l1);
		l2.add(9);
		System.out.println("");
		Iterator<Integer> itList1 = l2.iterator();
		while(itList1.hasNext()) System.out.println(itList1.next());
		
	}

}
