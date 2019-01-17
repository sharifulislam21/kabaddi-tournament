package com.mo.kabaddi.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mo.kabaddi.entity.Match;
import com.mo.kabaddi.entity.Team;
import com.mo.kabaddi.service.MatchScheduler;
import com.mo.kabaddi.util.MatchDateComparator;

@Service
public class MatchSchedulerImpl implements MatchScheduler {

	private static final Logger LOGGER = LoggerFactory.getLogger(MatchSchedulerImpl.class);

	private List<Match> initializeMatches(List<Team> teamList) {

		List<Match> matches = new ArrayList<>();

		for (Team teamA : teamList) {
			for (Team teamB : teamList) {
				if (teamA.getId() != teamB.getId()) {
					Match match = new Match(teamA, teamB);
					match.setLocation(teamA.getCity());
					matches.add(match);
				}
			}
		}
		return matches;
	}

	private boolean isMatchScheduled(List<Match> matches) {
		for (Match match : matches) {
			if (match.getDate() == null) {
				return true;
			}
		}
		return false;
	}

	private List<Integer> prepareParticipatedTeamList(List<Match> matches, Date date) {
		List<Integer> teamIds = new ArrayList<>();
		for (Match match : matches) {
			if (match.getDate() != null) {
				if (date.equals(match.getDate())) {
					teamIds.add(match.getTeamA().getId());
					teamIds.add(match.getTeamB().getId());
				}
			}
		}
		return teamIds;
	}

	List<Match> sortByDate(List<Match> matches) {
		matches.sort(new MatchDateComparator());
		return matches;
	}

	@Override
	public List<Match> generate(List<Team> teamList, Date startDate) {
		// List of matches
		List<Match> matches = initializeMatches(teamList);

		// Tournament start date
		DateTime currentDate = new DateTime(startDate.getTime());

		while (isMatchScheduled(matches)) {

			List<Integer> participatedTeamIds = prepareParticipatedTeamList(matches,
					currentDate.minus(Period.days(1)).toDate());

			Random random = new Random();
			Collections.swap(matches, random.nextInt(matches.size()), random.nextInt(matches.size()));

			for (Match match : matches) {
				if (match.getDate() == null && !participatedTeamIds.contains(match.getTeamA().getId())
						&& !participatedTeamIds.contains(match.getTeamB().getId())) {

					match.setDate(currentDate.toDate());
					participatedTeamIds.add(match.getTeamA().getId());
					participatedTeamIds.add(match.getTeamB().getId());
				}
			}
			currentDate = currentDate.plus(Period.days(1));
		}

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		for (Match match : matches) {
			if (match.getDate() == null) {
				System.out.println("Date is null!");
			} else {
				match.setMatchDate(df.format(match.getDate()));
			}
		}

		matches = sortByDate(matches);
		LOGGER.info("Matches :" + matches);
		return matches;
	}

}
