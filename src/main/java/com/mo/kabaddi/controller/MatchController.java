package com.mo.kabaddi.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.kabaddi.entity.Match;
import com.mo.kabaddi.service.MatchService;

@RestController
@RequestMapping("/kabaddi")
public class MatchController {

	@Autowired
	private MatchService matchService;

	@GetMapping(value = "/schedule", produces = "application/json")
	public ResponseEntity<?> getMatchSchedule(@QueryParam("teamIds") String teamIds,
			@QueryParam("startDate") String startDate) {
		ResponseEntity<List<Match>> responseEntity = new ResponseEntity<List<Match>>(matchService.getMatchSchedule(teamIds, startDate), HttpStatus.OK);
		return responseEntity;
	}
	
}
