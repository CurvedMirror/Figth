package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AirportsDao;
import dao.BaseDao;
import entity.Airports;

public class AripostsDaoImpl extends BaseDao implements AirportsDao {

	@Override
	public List<Airports> getAllInfo() {
		List<Airports> list =new ArrayList<Airports>();
		String sql ="SELECT  * FROM `airports`";
		rs = executeQuery(sql);
		try {
			while(rs.next()){
				Airports airports = tableToClass(rs);
				list.add(airports);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}

	public Airports tableToClass(ResultSet rs) throws SQLException {
		Airports airports  =new Airports();
		airports.setAirportName(rs.getString("airportName"));
		airports.setCityName(rs.getString("cityName"));
		airports.setId(rs.getInt("id"));
		return airports;
	}

}
