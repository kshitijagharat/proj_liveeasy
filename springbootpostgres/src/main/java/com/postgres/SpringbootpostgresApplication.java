package com.postgres;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringbootpostgresApplication  {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootpostgresApplication.class, args);
	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		//this.loadDao.createTable();
//		this.loadDao.insertData("delhi","jaipur","chemicals", "canter",1,100," Hiii", 868,"10-12-1973");
//	}

}
