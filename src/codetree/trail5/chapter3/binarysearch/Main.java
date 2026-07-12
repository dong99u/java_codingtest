package codetree.trail5.chapter3.binarysearch;

public class Main {
	static int n = 8;
	static int[] arr = {2, 2, 5, 7, 7, 7, 9, 10};

	public static void main(String[] args) {
		System.out.println(lowerBound(8));
		System.out.println(upperBound(8));
	}

	static int lowerBound(int target) {
		int left = 0, right = n - 1;
		int minIdx = n;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] >= target) {
				right = mid - 1;
				minIdx = Math.min(minIdx, mid);
			} else {
				left = mid + 1;
			}
		}
		return minIdx;
	}

	static int upperBound(int target) {
		int left = 0, right = n - 1;
		int minIdx = n;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] > target) {
				right = mid - 1;
				minIdx = Math.min(minIdx, mid);
			} else {
				left = mid + 1;
			}
		}
		return minIdx;
	}

}
