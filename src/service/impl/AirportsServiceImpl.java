package service.impl;

import java.util.List;

import service.AirpotrsService;

import dao.AirportsDao;
import dao.impl.AripostsDaoImpl;
import entity.Airports;

public class AirportsServiceImpl implements AirpotrsService {

	private AirportsDao airportsDao = new AripostsDaoImpl();

	@Override
	public List<Airports> getAllInfo() {
		// TODO Auto-generated method stub
		return airportsDao.getAllInfo();
	}

}
