package chapter7.dao;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDao {
	//定义一个保存图书信息的静态map对象
	private static Map<String,Integer> books = new LinkedHashMap<String,Integer>();
	//在静态块中对map对象进行初始化，map的key表示书名，map的value表示价格
	static{
		books.put("j2ee整合详解与典型案例", 79);
		books.put("Visual C# 2008开发技术实例详解", 89);
		books.put("STRUTS2技术详解", 69);
		books.put("ASP经典模块开发大全", 69);
		books.put("ASP.NET3.5网络数据库开发实例学习手册", 79);
		books.put("XML开发典型应用：数据标记、处理、共享与分析", 65);
	}
	//根据书名进行模糊查询，返回用于保存查询结果的map对象
	public Map<String,Integer> getBooks(String name){
		Map<String, Integer> books = new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, Integer> entry: BookDao.books.entrySet()){
			if(entry.getKey().toLowerCase().contains(name.toLowerCase())){
				books.put(entry.getKey(), entry.getValue());
			}
		}
		return books;
	}
}
