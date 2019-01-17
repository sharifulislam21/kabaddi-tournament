package com.mo.kabaddi.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Match {

	private final Team teamA;
	private final Team teamB;
	private String location;
	@JsonIgnore
	private Date date;
	private String matchDate;
}
