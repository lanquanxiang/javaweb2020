package cn.pzhuweb.test.service.imp;

import java.util.List;

import cn.pzhuweb.test.dao.CarDAO;
import cn.pzhuweb.test.dao.imp.CarDAOImp;
import cn.pzhuweb.test.pojo.Car;
import cn.pzhuweb.test.pojo.Message;
import cn.pzhuweb.test.service.CarService;

public class CarServiceImp implements CarService{

	private CarDAO dao = new CarDAOImp();
	@Override
	public List<Car> showAllCarInfo() { 
		return dao.select();
	}

	@Override
	public Message inserCarInfo(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message removeCarInfo(Integer carid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message editCarInfo(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> searchCarInfoByKeywords(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
