package com.HouseRental.comcast.genricutility;

import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random=new Random();
		int randomNum = random.nextInt();
		return randomNum;
	}
}
