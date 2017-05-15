package chapter7.dao;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDao {
	//����һ������ͼ����Ϣ�ľ�̬map����
	private static Map<String,Integer> books = new LinkedHashMap<String,Integer>();
	//�ھ�̬���ж�map������г�ʼ����map��key��ʾ������map��value��ʾ�۸�
	static{
		books.put("j2ee�����������Ͱ���", 79);
		books.put("Visual C# 2008��������ʵ�����", 89);
		books.put("STRUTS2�������", 69);
		books.put("ASP����ģ�鿪����ȫ", 69);
		books.put("ASP.NET3.5�������ݿ⿪��ʵ��ѧϰ�ֲ�", 79);
		books.put("XML��������Ӧ�ã����ݱ�ǡ��������������", 65);
	}
	//������������ģ����ѯ���������ڱ����ѯ�����map����
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
