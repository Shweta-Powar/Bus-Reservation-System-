package miniproject.model;

public class Bus {
	public int id,price,totalseats;
	public String busname,bustype,locations,mtime,ntime;
	public Bus() {
		
	}
public Bus(int id,String busname, int price, int totalseats,String bustype, String locations, String mtime, String ntime) {
		super();
		this.id = id;
		this.price = price;
		this.totalseats = totalseats;
		this.busname = busname;
		this.bustype=bustype;
		this.locations = locations;
		this.mtime = mtime;
		this.ntime = ntime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}

	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getNtime() {
		return ntime;
	}
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
	@Override
	public String toString() {
		return "Bus [id=" + id + ", price=" + price + ", totalseats=" + totalseats + ", busname=" + busname
				+ ", bustype=" + bustype + ", locations=" + locations + ", mtime=" + mtime + ", ntime=" + ntime + "]";
	}
	
	
	
}
