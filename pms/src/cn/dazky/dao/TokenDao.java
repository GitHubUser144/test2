package cn.dazky.dao;

import java.util.List;

import cn.dazky.entity.Token;

public interface TokenDao {
	/**
	 * 查询标记信息表中的所有数据
	 * @return
	 */
	public List<Token> selectAllTokens();
	
	/**
	 * 根据id查询标记信息
	 * @param 标记信息id
	 * @return 一个标记信息对象
	 */
	public Token selectTokenById(int id);
	
	/**
	 * 根据id删除标记信息
	 * @param 标记信息id
	 * @return 是否删除成功
	 */
	public boolean deleteTokenById(int id);
	
	/**
	 * 添加一个标记信息
	 * @param 标记信息对象
	 * @return 是否添加成功
	 */
	public boolean addToken(Token token);
	
	/**
	 * 更新一个标记信息的数据
	 * @param 标记信息对象
	 * @return 是否修改成功
	 */
	public boolean updateToken(Token token);
}
