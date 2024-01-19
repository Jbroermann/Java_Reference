package circularQueueExampleFromClass;

public class Homework4 {

	public static void main(String[] args) {
		
		
		int[] ray = {0, 1, 2, 3, 4, 5};
		//			{x, R,  ,  , F, x}
		int REALFront = 4;
		int front = REALFront;
		int rear = 1;
		
		int size = 0;
		while (front != rear) {
			//System.out.println(ray[front]);
			front = (front+1)%ray.length;
			size++;
		}
		System.out.println(size);
		
		
	}

}
