package com.mo.kabaddi.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.mo.kabaddi.dao.impl.TeamDaoImpl;
import com.mo.kabaddi.entity.Team;

@Repository
public class TeamRepositoryImpl {

	public Team fetchTeam(int id) {
		Team team = new TeamDaoImpl().getTeam(id);
		Assert.notNull(team, "Team does not exist for id -> " + id);
		return team;
	}

}
