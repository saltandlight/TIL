package vo;

public class Factory {
	String factno;
	String facname;
	String facloc;
	
	public Factory() {
	}

	public Factory(String factno, String facname, String facloc) {
		this.factno = factno;
		this.facname = facname;
		this.facloc = facloc;
	}

	public String getFactno() {
		return factno;
	}

	public void setFactno(String factno) {
		this.factno = factno;
	}

	public String getFacname() {
		return facname;
	}

	public void setFactname(String facname) {
		this.facname = facname;
	}

	public String getFacloc() {
		return facloc;
	}

	public void setFacloc(String facloc) {
		this.facloc = facloc;
	}

	@Override
	public String toString() {
		return "Factory [factno=" + factno + ", facname=" + facname + ", facloc=" + facloc + "]";
	}

	
}
