public class PracticeProblem {

	public static int fib(int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		int[] memoization = new int[num + 1];

		for (int i = 0; i < memoization.length; i++) {
			memoization[i] = -1;
		}

		return fibHelper(num, memoization);

	}

	private static int fibHelper(int num, int[] memo) {
		if (num == 0 || num == 1) {
			return num;
		}
		if (memo[num] != -1) {
			return memo[num];
		}

		memo[num] = fibHelper(num - 1, memo) + fibHelper(num - 2, memo);
		return memo[num];
	}

	public static int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0) {
			return 0;
		}
		if (cost.length == 1) {
			int[] memo = new int[2];
			for(int i = 0; i < memo.length; i++) {
				memo[i] = -1;
			}
			return minCostClimbingStairsHelper(0, cost, memo);
		}

		int[] memo = new int[cost.length + 1];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1;
		}
		return Math.min(minCostClimbingStairsHelper(cost.length - 1, cost, memo), minCostClimbingStairsHelper(cost.length - 2, cost, memo));

	}

	private static int minCostClimbingStairsHelper(int i, int[] cost, int[] memo) {
		if (i == 0) {
			return cost[0];
		}
		if (i == 1) {
			return cost[1];
		}
		if (memo[i] != -1) {
			return memo[i];
		}
		memo[i] = cost[i] + Math.min(minCostClimbingStairsHelper(i - 1, cost, memo), minCostClimbingStairsHelper(i - 2, cost, memo));
		return memo[i];
	}

	public static void main(String args[]) {
		int result = fib(0);
		System.out.println(result);

		int[] cost = {10, 15, 20, 25, 30};
		int result2 = minCostClimbingStairs(cost);
		System.out.println(result2);
	}

	
}
