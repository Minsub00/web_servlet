package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class exam2 {
	
	public static void main(String[] args) {
		new ex2_box().aaa();
	}
}

class ex2_box{
	Scanner sc = null;
	ArrayList<Integer> user = null;
	ArrayList<Integer> pc = null;
	public ex2_box() {
		this.sc = new Scanner(System.in);
		this.user = new ArrayList<Integer>();
		this.pc = new ArrayList<Integer>();
	}
	public Integer pc_return() {
		Integer npc = (int)Math.ceil(Math.random()*46);
		if(this.pc.contains(npc) == false) {
			this.pc.add(npc);
			pc_return();
		}
		return npc;
	}
	public void aaa() {
		try {
			while(true) {
				if(this.user.size() == 0) {
					break;
				}
				if(this.pc.size() < 7) {
					Integer npc = (int)Math.ceil(Math.random()*46);
					if(this.pc.contains(npc) == false) {
						this.pc.add(npc);
						pc_return();
					} else {
						Integer result = this.pc_return();
						this.pc.add(result);
					}
				}
				System.out.println("숫자를 입력하세요 (1~46)");		
				Integer no = this.sc.nextInt();
				if(no>0 && no<=46) {
					if(this.user.contains(no) == false) {
						this.user.add(no);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요.");
			new ex2_box().aaa();
		} finally {
			sc.close();
		}
		this.aaa();
	}
}