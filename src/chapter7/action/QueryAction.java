package chapter7.action;

import java.util.Map;

import chapter7.dao.BookDao;

public class QueryAction {
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	private Map<String, Integer> result;
	
	public Map<String, Integer> getResult(){
		return result;
	}
	public void setResult(Map<String, Integer> result){
		this.result = result;
	}
	
	public String execute() throws Exception{
		try{
			BookDao book = new BookDao();
			Map<String, Integer> books = book.getBooks(name);
			setResult(books);
			return "success";
		}catch (Exception e){
			return "error";
		}
	}
}
