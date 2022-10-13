package com.postgres.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;


    @Entity
    @Table(name ="loads")
    public class Load {
    	
    	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shipperId;
	@Column(name = "loading_Point" )
	private String loadingPoint;
	@Column(name = "unloading_Point" )
	private String unloadingPoint;
	@Column(name = "product_Type" )
	private String productType;
	@Column(name = "truck_Type" )
	private String truckType;
	@Column(name = "no_Of_Trucks" )
	private long noOfTrucks;
	@Column(name = "weight" )
	private int weight;
	@Column(name = "comment" )
	private String comment;
	@Column(name = "date" )
	private Date date;
	
	
	public Load(String loadingPoint, String unloadingPoint, String productType, String truckType, long noOfTrucks,
			int weight, long shipperId, String comment, Date date) {
		super();
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTrucks = noOfTrucks;
		this.weight = weight;
		this.comment = comment;
		this.date = date;
	}
	public Load() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLoadingPoint() {
		return loadingPoint;
	}
	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}
	public String getUnloadingPoint() {
		return unloadingPoint;
	}
	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public long getNoOfTrucks() {
		return noOfTrucks;
	}
	public void setNoOfTrucks(long noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	

	
	public long getShipperId() {
		return shipperId;
	}
	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Load [shipperId=" + shipperId + ", loadingPoint=" + loadingPoint + ", unloadingPoint=" + unloadingPoint
				+ ", productType=" + productType + ", truckType=" + truckType + ", noOfTrucks=" + noOfTrucks
				+ ", weight=" + weight + ", comment=" + comment + ", date=" + date + "]";
	}
	
	
	
	
	
	
	
	
	
}
