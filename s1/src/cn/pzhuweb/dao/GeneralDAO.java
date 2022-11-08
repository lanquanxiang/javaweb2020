package cn.pzhuweb.dao;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * @author Administrator
 *
 * @param <T> 使用泛型来表示某一个类（表的映射）
 * @param <K> 使用泛型来表示某一个类型（表的主键类型）
 */
public interface GeneralDAO<T,K extends Serializable> {
	public int insert(T t);
	public int delete(K k);
	public int update(T t);
	public T selectById(K k);
	public List<T> selectAll();
}
