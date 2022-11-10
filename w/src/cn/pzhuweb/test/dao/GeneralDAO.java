package cn.pzhuweb.test.dao;

import java.io.Serializable;
/**
 * 
 * @author Administrator
 *
 * @param <T> 表示的是某张表的映射类型
 * @param <K> 表示的是某张表的主键类型
 */
import java.util.List;
public interface GeneralDAO<T,K extends Serializable> {
	public int insert(T t);
	public int delete(K k);
	public int update(T t);
	public T selectById(K k);
	public List<T> select();
}
