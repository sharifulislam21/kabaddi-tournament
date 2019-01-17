package com.mo.kabaddi.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mo.kabaddi.entity.Match;
import com.mo.kabaddi.entity.Team;
import com.mo.kabaddi.repository.impl.TeamRepositoryImpl;
import com.mo.kabaddi.service.MatchScheduler;
import com.mo.kabaddi.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchScheduler matchScheduler;

	@Autowired
	TeamRepositoryImpl teamRepository;

	public static final Logger LOGGER = LoggerFactory.getLogger(MatchServiceImpl.class);

	@Override
	public List<Match> getMatchSchedule(String teamIds, String startDate) {

		Assert.notNull(teamIds, "teamIds Query Parameter is missing");
		Assert.notNull(startDate, "startDate Query Parameter is missing");

		String[] teamIdArray = StringUtils.split(teamIds, ",");

		// Format Start Date
		Date scheduleStartDate = parseDate(startDate);

		// Team List
		List<Team> teams = new ArrayList<>();

		for (String teamId : teamIdArray) {
			if (StringUtils.isNumeric(teamId)) {
				teams.add(teamRepository.fetchTeam(Integer.valueOf(teamId)));
			} else {
				throw new RuntimeException("Team Id should be a number");
			}

		}
		LOGGER.info("Participating teams :" + teams);
		return matchScheduler.generate(teams, scheduleStartDate);
	}

	private Date parseDate(String startDate) {

		DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		try {
			return dateFormatter.parse(startDate);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
