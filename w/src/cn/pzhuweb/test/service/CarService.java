package cn.pzhuweb.test.service;

import java.util.List;

import cn.pzhuweb.test.pojo.Car;
import cn.pzhuweb.test.pojo.Message;

public interface CarService {
	//1. 显示所有汽车信息
	public List<Car> showAllCarInfo();
	//2. 插入汽车信息
	public Message inserCarInfo(Car car);
	//3. 删除汽车信息
	public Message removeCarInfo(Integer carid);
	//4. 更新汽车信息
	public Message editCarInfo(Car car);
	//5. 按照关键词检索信息
	public List<Car> searchCarInfoByKeywords(String keywords);
	//6. 判断汽车信息是否存在
	public boolean isExist(Integer id);
}
