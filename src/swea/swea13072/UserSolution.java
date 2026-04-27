package swea.swea13072;

import java.util.*;

class UserSolution
{
	static Map<Integer, Integer> idToTeam; // mID -> mTeam
	static TreeSet<Integer>[][] bucket; // bucket[team][score] = ID들

	public void init()
	{
		idToTeam = new HashMap<>();
		bucket = new TreeSet[6][6];
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				bucket[i][j] = new TreeSet<>();
			}
		}
	}

	public void hire(int mID, int mTeam, int mScore)
	{
		idToTeam.put(mID, mTeam);
		bucket[mTeam][mScore].add(mID);
	}

	public void fire(int mID)
	{
		int teamID = idToTeam.get(mID);
		for (int score = 1; score <= 5; score++) {
			if (bucket[teamID][score].contains(mID)) {
				bucket[teamID][score].remove(mID);
				break;
			}
		}

	}

	public void updateSoldier(int mID, int mScore)
	{
		int teamID = idToTeam.get(mID);
		for (int score = 1; score <= 5; score++) {
			if (bucket[teamID][score].contains(mID)) {
				bucket[teamID][score].remove(mID);
				bucket[teamID][mScore].add(mID);
				break;
			}
		}
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		TreeSet<Integer>[] newBucket = new TreeSet[6];
		for (int i = 1; i <= 5; i++) {
			newBucket[i] = new TreeSet<>();
		}
		for (int score = 1; score <= 5; score++) {
			int targetScore = score + mChangeScore < 1 ? 1 : score + mChangeScore > 5 ? 5 : score + mChangeScore;

			TreeSet<Integer> source = bucket[mTeam][score];
			if (source.isEmpty()) continue;

			if (newBucket[targetScore].isEmpty()) {
				newBucket[targetScore] = source;
			} else {
				TreeSet<Integer> dest = newBucket[targetScore];
				if (source.size() > dest.size()) {
					TreeSet<Integer> tmp = source;
					source = dest;
					dest = tmp;
				}
				dest.addAll(source);
				newBucket[targetScore] = dest;
			}
		}

		for (int i = 1; i <= 5; i++) {
			bucket[mTeam][i] = newBucket[i];
		}
	}

	public int bestSoldier(int mTeam)
	{
		for (int i = 5; i >= 1; i--) {
			if (!bucket[mTeam][i].isEmpty()) {
				return bucket[mTeam][i].last();
			}
		}
		return -1;
	}
}