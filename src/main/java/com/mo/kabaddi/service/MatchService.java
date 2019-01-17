package com.mo.kabaddi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.kabaddi.entity.Match;

@Service
public interface MatchService {

	List<Match> getMatchSchedule(String teamIds, String startDate);

}
