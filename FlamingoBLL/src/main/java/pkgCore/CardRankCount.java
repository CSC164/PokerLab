package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class CardRankCount implements Comparable {
 
	private eRank eRank;
	private int iCnt;
	private int iCardPosition;
	public CardRankCount(pkgEnum.eRank eRank, int iCnt, int iCardPosition) {
		super();
		this.eRank = eRank;
		this.iCnt = iCnt;
		this.iCardPosition = iCardPosition;
	}
	protected eRank geteRank() {
		return eRank;
	}
	protected void seteRank(eRank eRank) {
		this.eRank = eRank;
	}
	protected int getiCnt() {
		return iCnt;
	}
	protected void setiCnt(int iCnt) {
		this.iCnt = iCnt;
	}
	protected int getiCardPosition() {
		return iCardPosition;
	}
	protected void setiCardPosition(int iCardPosition) {
		this.iCardPosition = iCardPosition;
	}
	@Override
	public int compareTo(Object o) {
		
		CardRankCount crc = (CardRankCount) o;
		
			if (crc.getiCnt() - this.getiCnt() != 0)
				return crc.getiCnt() - this.getiCnt() ;
 
		
		return crc.geteRank().compareTo(this.geteRank());

	}
	
}
