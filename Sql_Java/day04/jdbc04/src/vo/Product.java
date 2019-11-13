package vo;

import java.sql.Date;

public class Product {
	int pdno;		
	String pdname;
	String pdsubname;
	String factno;
	Date pddate;
	int pdcost;
	int pdprice;
    int pdamount;
    
    
	public Product() {
		
	}


	public Product(int pdno, String pdname, String pdsubname, String factno, Date pddate, int pdcost, int pdprice,
			int pdamount) {
		this.pdno = pdno;
		this.pdname = pdname;
		this.pdsubname = pdsubname;
		this.factno = factno;
		this.pddate = pddate;
		this.pdcost = pdcost;
		this.pdprice = pdprice;
		this.pdamount = pdamount;
	}
    
    
	public int getPdno() {
		return pdno;
	}
	public void setPdno(int pdno) {
		this.pdno = pdno;
	}
	public String getPdname() {
		return pdname;
	}
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
	public String getPdsubname() {
		return pdsubname;
	}
	public void setPdsubname(String pdsubname) {
		this.pdsubname = pdsubname;
	}
	public String getFactno() {
		return factno;
	}
	public void setFactno(String factno) {
		this.factno = factno;
	}
	public Date getPddate() {
		return pddate;
	}
	public void setPddate(Date pddate) {
		this.pddate = pddate;
	}
	public int getPdcost() {
		return pdcost;
	}
	public void setPdcost(int pdcost) {
		this.pdcost = pdcost;
	}
	public int getPdprice() {
		return pdprice;
	}
	public void setPdprice(int pdprice) {
		this.pdprice = pdprice;
	}
	public int getPdamount() {
		return pdamount;
	}
	public void setPdamount(int pdamount) {
		this.pdamount = pdamount;
	}
	
	
	@Override
	public String toString() {
		return "Product [pdno=" + pdno + ", pdname=" + pdname + ", pdsubname=" + pdsubname + ", factno=" + factno
				+ ", pddate=" + pddate + ", pdcost=" + pdcost + ", pdprice=" + pdprice + ", pdamount=" + pdamount + "]";
	}
    
    
}
