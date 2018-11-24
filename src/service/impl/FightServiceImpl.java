package service.impl;

import java.util.List;

import dao.FightDao;
import dao.impl.FightDaoImpl;

import entity.Fights;
import entity.Page;
import service.FightService;

public class FightServiceImpl implements FightService {

	private FightDao fightDao  =new FightDaoImpl();
	
	@Override
	public List<Fights> getAll(Page page, String fightDate,
			String tokeoffAirportId, String landingAirportId) {
		return fightDao.getAll(page, fightDate, tokeoffAirportId, landingAirportId);
	}

	@Override
	public Fights getById(int id) {
		return fightDao.getById(id);
	}

	@Override
	public int addInfo(Fights fights) {
		return fightDao.addInfo(fights);
	}

	@Override
	public int getTotalCount( String fightDate,
			String tokeoffAirportId, String landingAirportId) {
		return fightDao.getTotalCount( fightDate, tokeoffAirportId, landingAirportId);
	}
	
}
