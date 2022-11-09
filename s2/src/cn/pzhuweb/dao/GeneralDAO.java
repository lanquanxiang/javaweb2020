package cn.pzhuweb.dao;

import java.io.Serializable;
/**
 * 泛型公共接口，定义所有表的基本操作
 * @author Administrator
 *
 * @param <T> 表示某一个表的映射类型
 * @param <K> 表示某一个表的主键类型
 */
import java.util.List;
public interface GeneralDAO<T,K extends Serializable> {
	public int insert(T t);
	public int delete(K k);
	public int update(T t);
	public List<T> select();
	public T selectById(K k);
}
