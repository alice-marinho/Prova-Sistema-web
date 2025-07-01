package model;

import java.sql.Date;

public class Order {
    private Integer ordNo;
    private Double purchAmt;
    private Date ordDate;
    private Integer customerId;
    private Integer salesmanId;
    
    public Integer getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(Integer ordNo) {
		this.ordNo = ordNo;
	}
	public Double getPurchAmt() {
		return purchAmt;
	}
	public void setPurchAmt(Double purchAmt) {
		this.purchAmt = purchAmt;
	}
	public Date getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}
	

}
