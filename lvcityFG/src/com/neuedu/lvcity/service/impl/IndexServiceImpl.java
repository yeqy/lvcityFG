package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.IndexDao;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.service.IndexService;

public class IndexServiceImpl implements IndexService {
	/**
	 * 类实例
	 */
	private static final IndexService instance = new IndexServiceImpl();
	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static IndexService getInstance() {
		return instance;
	}
	/**
	 * 构造方法
	 */
	private IndexServiceImpl() {
		
	}
	
	@Override
	public List<Banar> findBanar() {
		Connection conn = null;
		List<Banar> banars = null;
		
		try {
			conn = DBUtils.getConnection();
			IndexDao indexDao = new IndexDaoImpl(conn);
			banars = indexDao.findBanar();
		} catch(Exception e) {
			System.out.println("查找banar出现错误..."+e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
		}				
		return banars;
	}

	@Override
	public List<Article> findIndexArticle() {
		Connection conn = null;
		List<Article> articles = null;
		
		try {
			conn = DBUtils.getConnection();
			IndexDao indexDao = new IndexDaoImpl(conn);
			articles = indexDao.findIndexArticle();
		} catch(Exception e) {
			System.out.println("查找article出现错误..."+e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
		}				
		return articles;
	}

	@Override
	public List<Scenic> findIndexScenic() {
		Connection conn = null;
		List<Scenic> scenics = null;
		
		try {
			conn = DBUtils.getConnection();
			IndexDao indexDao = new IndexDaoImpl(conn);
			scenics = indexDao.findIndexScenic();
		} catch(Exception e) {
			System.out.println("查找scenic出现错误..."+e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
		}				
		return scenics;
	}

	@Override
	public List<Food> findIndexFood() {
		Connection conn = null;
		List<Food> foods = null;
		
		try {
			conn = DBUtils.getConnection();
			IndexDao indexDao = new IndexDaoImpl(conn);
			foods = indexDao.findIndexFood();
		} catch(Exception e) {
			System.out.println("查找food出现错误..."+e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
		}				
		return foods;
	}

}
