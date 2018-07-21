package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.FoodType;
import com.neuedu.lvcity.model.Scenic;

public interface IndexDao {
	public List<Banar> findBanar(); //广告大图
	public List<Article> findIndexArticle(); //首页文章
	public List<Scenic> findIndexScenic(); //首页风景图片
	public List<Food> findIndexFood(); //首页美食图片
	
	public List<FoodType> findFoodIndexType(); //美食页面的美食类型
	public List<Contact> findContact(); //联系方式

}
