package cn.pzhuweb.service.imp;

import java.util.List;

import cn.pzhuweb.dao.CarDAO;
import cn.pzhuweb.dao.imp.CarDAOImp;
import cn.pzhuweb.pojo.Car;
import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.service.CarService;

public class CarServiceImp implements CarService{
	
	private CarDAO dao = new CarDAOImp();

	@Override
	public List<Car> showAllCarInfo() {
		return dao.select();
	}

	@Override
	public Message removeCarInfo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message editCarInfo(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message addCarInfo(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> searchCarInfoByKeywords(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

}
