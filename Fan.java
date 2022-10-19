package fan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fan {
	private int[] speedRange = {0,1,2,3,0,3,2,1};
	private int speed = 0;

	public int getSpeed() {
		return this.speedRange[this.speed];
	}
	
	public void pull() {
		if(speed == speedRange.length - 1) {
			speed = 0;
		} else {
			speed++;
		}
	}
	
	public static void main(String[] args) {
		Fan fan = new Fan();
		
		while(true) {
			System.out.println("current speed is "+fan.getSpeed());
			System.out.println("Please enter [pull] to change fan speed, enter [exit] to exit the program");
			
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String value = reader.readLine();
				if(value.equalsIgnoreCase("pull")) {
					fan.pull();
				}else if(value.equalsIgnoreCase("exit")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("unknown input, please try again");
			}
		}
		
		System.out.println("program has been quit");
	}
}
