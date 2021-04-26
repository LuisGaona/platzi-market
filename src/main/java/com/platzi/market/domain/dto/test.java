package com.platzi.market.domain.dto;

public class test {

	public static void main(String[] args) {
		
		 int arr[] = {2, 1, 1, 2, 1};
		    int n = arr.length;
		   System.out.println(method(arr));
		
	}
	
	public static boolean method(int[] nums) {
		int leftSum=0;
		
		for(int i=0; i<nums.length;i++) {
			leftSum+=nums[i];
			
		 int rightSum=0;
		 for(int j=i+1; j<nums.length; j++) {
			 rightSum+=nums[j];
		 }
		 if(leftSum==rightSum) {
			 return true;
		 }
		}
		return false;
	}
}
