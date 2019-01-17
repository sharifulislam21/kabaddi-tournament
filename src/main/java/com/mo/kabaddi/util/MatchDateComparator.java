package com.mo.kabaddi.util;

import java.util.Comparator;

import com.mo.kabaddi.entity.Match;

public class MatchDateComparator implements Comparator<Match> {
	public int compare(Match p, Match q) {
		if (p.getDate().before(q.getDate())) {
			return -1;
		} else if (p.getDate().after(q.getDate())) {
			return 1;
		} else {
			return 0;
		}
	}
}
