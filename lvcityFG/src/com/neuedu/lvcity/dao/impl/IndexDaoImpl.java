package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.IndexDao;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.FoodType;
import com.neuedu.lvcity.model.Scenic;

public class IndexDaoImpl implements IndexDao {
	/**
	 * 数据库连接
	 */
	private Connection conn;
	/**
	 * 构造方法
	 * 
	 * @param conn 数据库连接
	 */
	public IndexDaoImpl(Connection conn) {
		//给属性赋初始化值
		this.conn = conn;
	}

	@Override
	public List<Banar> findBanar() {
		List<Banar> list = new ArrayList<Banar>();
		ResultSet rs = null;
		PreparedStatement pstam = null;
		Banar ban = null;
		try {
			pstam = conn.prepareStatement("select * from banar ");
			rs = pstam.executeQuery();
			while(rs.next()) {
				//创建一个新用户对象，赋值给用户对象变量
				ban = new Banar();
				//调用结果集的getXxx方法，取出各个字段的值，再调用用户对象的setXxx方法保存在其中
				ban.setBanarid(rs.getInt("banarid"));
				ban.setImage(rs.getString("image"));
				ban.setState(rs.getInt("state"));
				//往List里添加记录
				list.add(ban);
			}
		} catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误..."+e.getMessage());
		} finally {
			//关闭声明对象的连接
			DBUtils.closeStatement(rs, pstam);
		}
		
		return list;
	}

	@Override
	public List<Article> findIndexArticle() {
		List<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("select aid,content,image,articlename from article where atid = 1");
			rs = pstam.executeQuery();
			while(rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setContent(rs.getString("content"));
				article.setImage(rs.getString("image"));
				article.setArticlename(rs.getString("articlename"));
				list.add(article);
			}
		} catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误..."+e.getMessage());
		} finally {
			//关闭声明对象的连接
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public List<Scenic> findIndexScenic() {
		List<Scenic> list = new ArrayList<Scenic>();
		ResultSet rs = null;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("select * from scenic order by sid desc limit 7");
			rs = pstam.executeQuery();
			while(rs.next()) {
				Scenic scenic = new Scenic();
				scenic.setSid(rs.getInt("sid"));
				scenic.setSid(rs.getInt("sid"));
				scenic.setSname(rs.getString("sname"));
				scenic.setImage(rs.getString("image"));
				scenic.setAid(rs.getInt("aid"));
				scenic.setLx(rs.getString("lx"));
				list.add(scenic);
			}
		} catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误..."+e.getMessage());
		} finally {
			//关闭声明对象的连接
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public List<Food> findIndexFood() {
		List<Food> list = new ArrayList<Food>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select fid,fname,aid,image from food order by fid desc limit 6");
			rs = pstam.executeQuery();
			while(rs.next()) {
				Food food = new Food();
				food.setFid(rs.getInt("fid"));
				food.setFname(rs.getString("fname"));
				food.setAid(rs.getInt("aid"));
				food.setImage(rs.getString("image"));
				list.add(food);
			}
		} catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误..."+e.getMessage());
		} finally {
			//关闭声明对象的连接
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public List<FoodType> findFoodIndexType() {
		List<FoodType> list = new ArrayList<FoodType>();
		PreparedStatement pstam = null;
		ResultSet rs = null;
		try {
			pstam = conn.prepareStatement("select fid,fname,aid,image from food order by fid desc limit 6");
			rs = pstam.executeQuery();
			while(rs.next()) {
				FoodType foodType = new FoodType();
				foodType.setFtid(rs.getInt("ftid"));
				foodType.setFt(rs.getString("ft"));
				list.add(foodType);
			}
		} catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误..."+e.getMessage());
		} finally {
			//关闭声明对象的连接
			DBUtils.closeStatement(rs, pstam);
		}
		return list;
	}

	@Override
	public List<Contact> findContact() {
		// TODO Auto-generated method stub
		return null;
	}

}
