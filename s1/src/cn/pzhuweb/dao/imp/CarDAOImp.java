package cn.pzhuweb.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.pzhuweb.dao.CarDAO;
import cn.pzhuweb.pojo.Car;
import cn.pzhuweb.util.DruidUtil;

public class CarDAOImp implements CarDAO{
	
	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDs());

	@Override
	public int insert(Car t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer k) {
		String sql="delete from car where car_id=?";
		return template.update(sql, k);
	}

	@Override
	public int update(Car t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Car selectById(Integer k) {
		String sql = "select * from car where car_id=?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<Car>(Car.class), k);
	}

	@Override
	public List<Car> selectAll() {
		String sql = "select * from car";
		return template.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
	}

	@Override
	public List<Car> selectByKeyWords(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Test
	public void test(){
		System.out.println(delete(new Integer(1)));
	}

}
