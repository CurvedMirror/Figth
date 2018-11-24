package service;

import java.sql.Date;
import java.util.List;

import entity.Fights;
import entity.Page;

public interface FightService {
	/**
	 * 按条件查询航班
	 * @param page
	 * @param fightDate
	 * @param tokeoffAirportId
	 * @param landingAirportId
	 * @return
	 */
	List<Fights> getAll(Page page,String fightDate,String tokeoffAirportId,String landingAirportId);
	/**
	 * 查询详情
	 * @param id
	 * @return
	 */
	Fights getById(int id);
	/**
	 * 添加航班
	 * @param fights
	 * @return
	 */
	int addInfo(Fights fights);
	/**
	 * 查询记录条数
	 * @param page
	 * @param fightDate
	 * @param tokeoffAirportId
	 * @param landingAirportId
	 * @return
	 */
	int getTotalCount(String fightDate,String tokeoffAirportId,String landingAirportId);
	
}
