package service;

import java.sql.Date;
import java.util.List;

import entity.Fights;
import entity.Page;

public interface FightService {
	/**
	 * ��������ѯ����
	 * @param page
	 * @param fightDate
	 * @param tokeoffAirportId
	 * @param landingAirportId
	 * @return
	 */
	List<Fights> getAll(Page page,String fightDate,String tokeoffAirportId,String landingAirportId);
	/**
	 * ��ѯ����
	 * @param id
	 * @return
	 */
	Fights getById(int id);
	/**
	 * ��Ӻ���
	 * @param fights
	 * @return
	 */
	int addInfo(Fights fights);
	/**
	 * ��ѯ��¼����
	 * @param page
	 * @param fightDate
	 * @param tokeoffAirportId
	 * @param landingAirportId
	 * @return
	 */
	int getTotalCount(String fightDate,String tokeoffAirportId,String landingAirportId);
	
}
