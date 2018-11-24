package entity;

public class Fights {
	private int id;
	private String fightCode;
	private String fightDate;
	private String airLine;
	private String type;
	private int tokeoffAirportId;
	private int landingAirportId;
	private String takeoffTime;
	private String landingTime;
	private String fightTime;
	private String stopAirport;
	private int referencePrice;
	private String seatPic;
	private String tokeoffAirportName;
	private String landingAirportName;

	public String getTokeoffAirportName() {
		return tokeoffAirportName;
	}

	public void setTokeoffAirportName(String tokeoffAirportName) {
		this.tokeoffAirportName = tokeoffAirportName;
	}

	public String getLandingAirportName() {
		return landingAirportName;
	}

	public void setLandingAirportName(String landingAirportName) {
		this.landingAirportName = landingAirportName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFightCode() {
		return fightCode;
	}

	public void setFightCode(String fightCode) {
		this.fightCode = fightCode;
	}

	public String getFightDate() {
		return fightDate;
	}

	public void setFightDate(String fightDate) {
		this.fightDate = fightDate;
	}

	public String getAirLine() {
		return airLine;
	}

	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTokeoffAirportId() {
		return tokeoffAirportId;
	}

	public void setTokeoffAirportId(int tokeoffAirportId) {
		this.tokeoffAirportId = tokeoffAirportId;
	}

	public int getLandingAirportId() {
		return landingAirportId;
	}

	public void setLandingAirportId(int landingAirportId) {
		this.landingAirportId = landingAirportId;
	}

	public String getTakeoffTime() {
		return takeoffTime;
	}

	public void setTakeoffTime(String takeoffTime) {
		this.takeoffTime = takeoffTime;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	public String getFightTime() {
		return fightTime;
	}

	public void setFightTime(String fightTime) {
		this.fightTime = fightTime;
	}

	public String getStopAirport() {
		return stopAirport;
	}

	public void setStopAirport(String stopAirport) {
		this.stopAirport = stopAirport;
	}

	public int getReferencePrice() {
		return referencePrice;
	}

	public void setReferencePrice(int referencePrice) {
		this.referencePrice = referencePrice;
	}

	public String getSeatPic() {
		return seatPic;
	}

	public void setSeatPic(String seatPic) {
		this.seatPic = seatPic;
	}

}
