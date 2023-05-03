package flow_01;

import org.testng.annotations.Test;

public class intro_testNG {
	
	@Test
	public void print_hello() {
		System.out.println("aaa");
	}
	
	public static void main(String[] args) {
		intro_testNG demo = new intro_testNG();
		demo.print_hello();
	}

}
