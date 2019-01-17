package com.mo.kabaddi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mo.kabaddi.entity.Team;

public class TeamDaoImpl {

	private static List<Team> teams = new ArrayList<>();

	private static List<Team> initializeTeam() {
		teams.add(prepareTeam(1, "Puneri Paltan", "Pune"));
		teams.add(prepareTeam(2, "Bengaluru Bulls", "Bengaluru"));
		teams.add(prepareTeam(3, "Dabang Delhi", "Delhi"));
		teams.add(prepareTeam(4, "Telugu Titans", "Hyderabad"));
		teams.add(prepareTeam(5, "Patna Pirates", "Patna"));
		teams.add(prepareTeam(6, "U Mumba", "Mumbai"));
		return teams;
	}

	private static Team prepareTeam(int id, String name, String city) {
		Team team = new Team();
		team.setId(id);
		team.setName(name);
		team.setCity(city);

		return team;

	}

	public Team getTeam(int id) {
		List<Team> teams = initializeTeam();
		for (Team team : teams) {
			if (id == team.getId()) {
				return team;
			}
		}
		return null;
	}

}
