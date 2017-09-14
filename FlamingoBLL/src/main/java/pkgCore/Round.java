package pkgCore;

import java.util.LinkedList;

import pkgEnum.eGameResult;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		Roll r = new Roll();
		ComeOutScore = r.getScore();
		rolls.add(r);

		switch (r.getScore()) {
		case 2:
		case 3:
		case 12:
			eGameResult = eGameResult.CRAPS;
			break;
		case 7:
		case 11:
			eGameResult = eGameResult.NATURAL;
			break;
		default:
			
			do {
				r = new Roll();
				rolls.add(r);
				if (r.getScore() == ComeOutScore) {
					eGameResult = eGameResult.POINT;
					break;
				} else if (r.getScore() == 7) {
					eGameResult = eGameResult.SEVEN_OUT;
					break;
				}

			} while (true);
		}

	}

	public int RollCount() {
		return rolls.size();
	}

	public int getComeOutScore() {
		return ComeOutScore;
	}

	public eGameResult geteGameResult() {
		return eGameResult;
	}

	public LinkedList<Roll> getRolls() {
		return rolls;
	}

}
