package com.postgres.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoadDao {
    @Autowired
	private JdbcTemplate jdbcTemplate;
    
    //create table...
	public void createTable()
	{
		var query="CREATE TABLE Load(loadingPoint varchar(255),unloadingPoint varchar(255),productType varchar(255),truckType varchar(255),noOfTrucks int,weight int,comment varchar(255),shipperId int,Date varchar(255))";
		int update = this.jdbcTemplate.update(query);
		System.out.println(update);
	}
	
	//inserting data
	public void insertData(String loadingPoint, String unloadingPoint, String productType, String truckType, long noOfTrucks,
			int weight, String comment, long shipperId, String date)
	{
		String q="insert into Load(loadingPoint,unloadingPoint, productType, truckType,noOfTrucks,weight, comment, shipperId, date) values(?,?,?,?,?,?,?,?,?)";
	    int update = this.jdbcTemplate.update(q,loadingPoint,unloadingPoint,productType,truckType,noOfTrucks,weight,comment,shipperId,date);
	    System.out.println(update +"rows added");
	
	}
}
