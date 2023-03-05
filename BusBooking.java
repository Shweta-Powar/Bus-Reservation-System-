package miniproject.model;

public class BusBooking {
	public int bid,seatNo,bseats = 0;
	public String desc,bdate, pstatus;
	public BusBooking() {
		
	}
	public BusBooking(int bid, int seatNo,int bseats, String desc,String pstatus,String bdate) {
		super();
		this.bid = bid;
		this.seatNo = seatNo;
		this.bseats = bseats;
		this.desc = desc;
		this.bdate = bdate;
		this.pstatus=pstatus;
	}
	
	public int getBseats() {
		return bseats;
	}


	public void setBseats(int bseats) {
		this.bseats = bseats;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getPstatus() {
		return pstatus;
	}


	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	@Override
	public String toString() {
		return "BusBooking [bid=" + bid + ", seatNo=" + seatNo + ", bseats=" + bseats + ", desc=" + desc + ", bdate="
				+ bdate + ", pstatus=" + pstatus + "]";
	}

	
	
}
