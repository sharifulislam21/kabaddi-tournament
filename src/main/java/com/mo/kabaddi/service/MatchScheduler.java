package com.mo.kabaddi.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.kabaddi.entity.Match;
import com.mo.kabaddi.entity.Team;

@Service
public interface MatchScheduler {

	List<Match> generate(List<Team> teamList, Date startDate);
}
