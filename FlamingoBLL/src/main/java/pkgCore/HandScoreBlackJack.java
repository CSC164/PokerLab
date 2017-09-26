package pkgCore;

import java.util.LinkedList;

public class HandScoreBlackJack extends HandScore {
	private LinkedList<Integer> NumericScores = new LinkedList<Integer>();
	
	public HandScoreBlackJack()
	{
		super();
	}
	protected LinkedList<Integer> getNumericScores() {
		return NumericScores;
	}
	protected void setNumericScores(LinkedList<Integer> numericScores) {
		NumericScores = numericScores;
	}
	protected void addScore(int iScore)
	{
		NumericScores.add(iScore);
	}

}
