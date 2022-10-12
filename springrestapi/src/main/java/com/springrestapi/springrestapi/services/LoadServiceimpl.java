package com.springrestapi.springrestapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.springrestapi.dao.LoadDao;
import com.springrestapi.springrestapi.entities.Load;

@Service
public class LoadServiceimpl implements LoadService {
	
	//List<Load> list;
	@Autowired
	private LoadDao loadDao;
	
	public LoadServiceimpl() {
		
//		list=new ArrayList<>();
//		list.add(new Load("delhi","jaipur","chemicals","canter",1,100,"hiii",6876,"12-03-1998"));
//		list.add(new Load("delhi","jaipur","chemicals","canter",2,170,"hiii welcome",5365,"12-09-1998"));
	}

	@Override
	public List<Load> getLoads() {
		
		//return list;
		return loadDao.findAll();
	}

	@Override
	public Load getLoad(long loadId) {
		
//		Load l=null;
//		for (Load load : list)
//		{
//			if(load.getShipperId()==loadId)
//			{
//				l=load;
//				break;
//			}
//		}
//		
//		return l;
		return loadDao.getReferenceById(loadId);
	}

	@Override
	public Load addLoad(Load load) {
	    //list.add(Load);
		loadDao.save(load);
		return load;
	}
    @Override
	public Load updateLoad(Load load) {
//	    list.forEach(e ->{
//	    	if(e.getId()==course.getId()) {
//	    		e.setTitle(load.getTitle());
//	    		e.setDescription(load.getDescription());
//	    	}
//	    });
    	loadDao.save(load);
		return load;
	}

	@Override
	public void deleteLoad(long parseLong) {
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
		Load entity=loadDao.getReferenceById(parseLong);
		loadDao.delete(entity);
		
	}

	
	
	
	
}
