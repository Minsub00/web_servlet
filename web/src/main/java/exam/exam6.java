package exam;

import java.util.Scanner;

public class exam6 {

	public static void main(String[] args) {
		 String [][] user = {
				 {"마동석", "1231231321"},
				 {"김무열", "4654654132"},
				 {"빅지환", "5468765156"}
		 };

	        Scanner sc = new Scanner(System.in);
	        System.out.println("고객명을 입력하세요: ");
	        String username = sc.nextLine().replaceAll(" ", "");

	        int w = 0;
	        while(w < user.length) {
	        	if(username.equals(user[w][0])) {
	        		
	        	}
	        }
	        
	        sc.close();
	}

}
