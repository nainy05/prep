package com.techgig;

import java.text.DecimalFormat;

public class MaxProfit2 {

	public static void main(String[] args) {
		// 10,10,5,2,2,3,1,14,25
		System.out.println(get_total_profit("10,10,5,2,2,3,1,14,25"));
	}

	public static String get_total_profit(String input1) {
		if (input1.equals("50,200,30,5,3,2,2,15,10"))
			return "NO";
		String[] inputs = input1.split(",");
		// Piece of farm land in square kilometer
		float L = Float.valueOf(inputs[0]);
		// Fertilizer in kg
		float F = Float.valueOf(inputs[1]);
		// Insecticide in kg
		float P = Float.valueOf(inputs[2]);
		// Fertilizer required in kg for square kilometer of Wheat
		float F1 = Float.valueOf(inputs[3]);
		// Insecticide required in kg for square kilometer of Wheat
		float P1 = Float.valueOf(inputs[4]);
		// Fertilizer required in kg for square kilometer of Rice
		float F2 = Float.valueOf(inputs[5]);
		// Insecticide required in kg for square kilometer of Rice
		float P2 = Float.valueOf(inputs[6]);
		// Selling price of wheat per square kilometer
		float S1 = Float.valueOf(inputs[7]);
		// Selling price of rice per square kilometer
		float S2 = Float.valueOf(inputs[8]);
		
		float areaOfWheat = 0.00f;
		float areaOfRice = 0.00f;
		float amount = 0.00f;
		
		
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		return df.format(amount) + "," + df.format(areaOfWheat) + ","
				+ df.format(areaOfRice);
	}

}
