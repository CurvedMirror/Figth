package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.FightDao;
import entity.Fights;
import entity.Page;

public class FightDaoImpl extends  BaseDao implements FightDao{

	public Fights tableToClass(ResultSet rs) throws SQLException {
		Fights fight = new Fights();
		fight.setAirLine(rs.getString("airLine"));
		fight.setFightCode(rs.getString("fightCode"));
		fight.setFightDate(rs.getString("fightDate"));
		fight.setFightTime(rs.getString("fightTime"));
		fight.setId(rs.getInt("id"));
//		fight.setLandingAirportId(rs.getInt("landingAirportId"));
		fight.setLandingTime(rs.getString("landingTime"));
		fight.setReferencePrice(rs.getInt("referencePrice"));
		fight.setSeatPic(rs.getString("seatPic"));
		fight.setStopAirport(rs.getString("stopAirport"));
		fight.setTakeoffTime(rs.getString("takeoffTime"));
//		fight.setTokeoffAirportId(rs.getInt("tokeoffAirportId"));
		fight.setType(rs.getString("type"));
		fight.setLandingAirportName(rs.getString("landingAirportName"));
		fight.setTokeoffAirportName(rs.getString("tokeoffAirportName"));
		return fight;
	}
	
	@Override
	public List<Fights> getAll(Page page, String fightDate,
			String tokeoffAirportId, String landingAirportId) {
		List<Fights> list = new ArrayList<Fights>();
		String sql = "select `id`, `fightCode`,`fightDate`,`airLine`, `type`," +
				"(SELECT airportName FROM airports WHERE id=tokeoffAirportId ) AS tokeoffAirportName," +
				"(SELECT airportName FROM airports WHERE id=landingAirportId ) AS landingAirportName," +
				" `takeoffTime`,  `landingTime`,  `fightTime`,  `stopAirport`,  `referencePrice`,  `seatPic` " +
				" from fights where 1=1";
		if(fightDate!=null && fightDate !=""){
			sql += " AND fightDate='"+fightDate+"'";
		}
		if(tokeoffAirportId!=null && tokeoffAirportId!=""){
			sql += " and tokeoffAirportId =(SELECT id FROM `airports` WHERE cityName='"+tokeoffAirportId+"')";
		}
		if(landingAirportId != null && landingAirportId!=""){
			sql += " AND landingAirportId=(SELECT id FROM `airports` WHERE cityName='"+landingAirportId+"') ";
		}
		sql += "  LIMIT ?,?";
		rs = executeQuery(sql,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
		try {
			while(rs.next()){
				Fights fight = new Fights();
				fight.setAirLine(rs.getString("airLine"));
				fight.setFightCode(rs.getString("fightCode"));
				fight.setFightDate(rs.getString("fightDate"));
				fight.setFightTime(rs.getString("fightTime"));
				fight.setId(rs.getInt("id"));
				fight.setLandingTime(rs.getString("landingTime"));
				fight.setReferencePrice(rs.getInt("referencePrice"));
				fight.setSeatPic(rs.getString("seatPic"));
				fight.setStopAirport(rs.getString("stopAirport"));
				fight.setTakeoffTime(rs.getString("takeoffTime"));
				fight.setType(rs.getString("type"));
				fight.setLandingAirportName(rs.getString("landingAirportName"));
				fight.setTokeoffAirportName(rs.getString("tokeoffAirportName"));
				list.add(fight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}

	@Override
	public Fights getById(int id) {
		Fights fight = new Fights();
		String sql = "SELECT * FROM `fights` WHERE id=?";
		rs = executeQuery(sql, id);
		try {
			while(rs.next()){
				fight.setAirLine(rs.getString("airLine"));
				fight.setFightCode(rs.getString("fightCode"));
				fight.setFightDate(rs.getString("fightDate"));
				fight.setFightTime(rs.getString("fightTime"));
				fight.setId(rs.getInt("id"));
				fight.setLandingAirportId(rs.getInt("landingAirportId"));
				fight.setLandingTime(rs.getString("landingTime"));
				fight.setReferencePrice(rs.getInt("referencePrice"));
				fight.setSeatPic(rs.getString("seatPic"));
				fight.setStopAirport(rs.getString("stopAirport"));
				fight.setTakeoffTime(rs.getString("takeoffTime"));
				fight.setTokeoffAirportId(rs.getInt("tokeoffAirportId"));
				fight.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return fight;
	}

	@Override
	public int addInfo(Fights fights) {
		String sql =  "INSERT INTO `flight`.`fights` (`fightCode`, `fightDate`, `airLine`, `type`, `tokeoffAirportId`, `landingAirportId`, `takeoffTime`, `landingTime`, `fightTime`, `stopAirport`, `referencePrice`, `seatPic`) " +
					"  VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
		int result = executeUpdate(sql, fights.getFightCode(),fights.getFightDate(),fights.getAirLine(),fights.getType(),fights.getTokeoffAirportId(),fights.getLandingAirportId(),fights.getTakeoffTime(),fights.getLandingTime(),fights.getFightTime(),fights.getStopAirport(),fights.getReferencePrice(),fights.getSeatPic());
		return result;
	}

	@Override
	public int getTotalCount(String fightDate,
			String tokeoffAirportId, String landingAirportId) {
		int count = 0;
		String sql = "select COUNT(id) from fights where 1=1";
		if(fightDate!=null && fightDate!=""){
			sql += " AND fightDate='"+fightDate+"'";
		}
		if(tokeoffAirportId!=null && tokeoffAirportId!=""){
			sql += " and tokeoffAirportId =(SELECT id FROM `airports` WHERE cityName='"+tokeoffAirportId+"')";
		}
		if(landingAirportId != null && landingAirportId!=""){
			sql += " AND landingAirportId=(SELECT id FROM `airports` WHERE cityName='"+landingAirportId+"') ";
		}
		rs = executeQuery(sql);
		try {
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return count;
	}
	
}
