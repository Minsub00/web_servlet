package exam;

import java.util.ArrayList;
import java.util.Arrays;

public class exam8 extends ex8_box{

	public static void main(String[] args) {
		new exam8().even();
		new exam8().odd();
	}
	@Override
	public void odd() {
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(data));
		int w = 0;
		while(w < number.size()) {
			if(number.get(w) % 2 != 1) {
				number.remove(w);
				w = 0;
			} else {
				w++;
			}
		}
		System.out.println(number);
	
	}
	@Override
	public void even() {
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(data));
		int w = 0;
		while(w < number.size()) {
			if(number.get(w) % 2 != 0) { 
				number.remove(w);
				w = 0; // 배열의 값이 삭제되면 처음부터 다시 검토(remove 사용시 node번호가 바뀌기 때문에 건너뛰어지는 값이 없도록 하기위함)
			} else {
				w++; // 짝수면 다음 노드를 검토
			}
		}
		System.out.println(number);
	}
}

abstract class ex8_box{
	Integer data[] = {3,5,2,1,6,7,8,9,10,4};

	abstract public void odd();
	abstract public void even();
	
}