package test;

import java.util.Arrays;
import java.util.Comparator;

public class RelativeRanks506 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] nums = {5,6,7,4,2};
System.out.println(Arrays.toString(findRelativeRanks(nums)));
	}

    public static String[] findRelativeRanks(int[] nums) {
    	ScoreAndIndex[] scoreAndIndex = new ScoreAndIndex[nums.length];
    	String[] s = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < nums.length; i++) {
            scoreAndIndex[i] = new ScoreAndIndex(nums[i], i);
        }
        Arrays.sort(scoreAndIndex, new Comparator<ScoreAndIndex>() {
			public int compare(ScoreAndIndex o1, ScoreAndIndex o2) {
				return o1.score - o2.score;
			}
        	
		});
        String[] ret = new String[nums.length];
        for (int i = 0; (i < ret.length) && (i < 3); i++) {
        	ret[scoreAndIndex[i].index] = s[i];
        }
        for (int i = 3; i < ret.length; i++) {
        	ret[scoreAndIndex[i].index] = "" + (i + 1);
        }
        return ret;
    }
    
    public static String[] findRelativeRanks1(int[] nums) {
    	int[][] pair = new int[nums.length][2];
    	String[] s = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        String[] ret = new String[nums.length];
        for (int i = 0; (i < ret.length) && (i < 3); i++) {
        	ret[pair[i][1]] = s[i];
        }
        for (int i = 3; i < ret.length; i++) {
        	ret[pair[i][1]] = "" + (i + 1);
        }
        return ret;
    }
}
class ScoreAndIndex {
	int score;
	int index;
	ScoreAndIndex(int score, int index) {
		this.score = score;
		this.index = index;
	};
}
