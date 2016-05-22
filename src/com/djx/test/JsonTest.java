package com.djx.test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import com.djx.entity.MyBean;
import com.djx.entity.Person;
import com.djx.entity.Student;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class JsonTest {
	private static void setDataFormate2Java(){
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"}));
	}

	@Test
	public void testJsonToObj() {
		String json="{id:'1001',name:'张三',age:'22'}";
		Student student=null;
		setDataFormate2Java();
		JSONObject object=JSONObject.fromObject(json);
		student=(Student) JSONObject.toBean(object,Student.class);
		System.out.println(student);
	}
	@Test
	public void testJsonArrToArry() {
		String jsonStu="[{id:1,name:'jack',age:20},{id:2,name:'rose',age:21},{id:1,name:'admin',age:20}]";
		JSONArray array=JSONArray.fromObject(jsonStu);
		Student[] stu=new Student[array.size()];
		for(int i=0;i<array.size();i++){
			JSONObject jsonObject=array.getJSONObject(i);
			stu[i]=(Student) jsonObject.toBean(jsonObject,Student.class);
		}
		System.out.println(stu[0]);
		System.out.println(stu[1]);
		System.out.println(stu[2]);
	}
	@Test
	public void testJsonArrToList() {
		String jsonStu="[{id:1,name:'jack',age:20},{id:2,name:'rose',age:21},{id:1,name:'admin',age:20}]";
		JSONArray array=JSONArray.fromObject(jsonStu);
		java.util.List<Student> stu=new ArrayList<>();
		for(int i=0;i<array.size();i++){
			JSONObject jsonObject=array.getJSONObject(i);
			stu.add((Student) jsonObject.toBean(jsonObject,Student.class));
		}
		System.out.println(stu.get(0));
		System.out.println(stu.get(1));
		System.out.println(stu.get(2));
	}
	@Test
	public void testArrayForJson(){
		String jsonString="['e','a','e']";
		JSONArray jsonArray=JSONArray.fromObject(jsonString);
		Object[] strs=jsonArray.toArray();
		for(Object object:strs){
			System.out.println(object);
		}
	}
	@Test
	public void testJsonStrToJson(){
		String json="['json','is','easy']";
		JSONArray jsonArray=JSONArray.fromObject(json);
		System.out.println(jsonArray);
	}
	@Test
	public void testMapToJson(){
		Map map=new HashMap<>();
		map.put("name", "jack");
		map.put("bool", Boolean.TRUE);
		map.put("age", new Integer(1));
		map.put("arr", new String[]{"a","b"});
		map.put("fun", "function(i){return i}");
		JSONObject jsonObject=JSONObject.fromObject(map);
		System.out.println(jsonObject);
	}
	@Test
	public void testObjectToJson(){
		JSONObject object=new JSONObject();
		object.put("pohone", "12345");
		object.put("zip", "obj");
		object.put("contact", object);
		System.out.println(object);
	}
	@Test
	public void testBeanToJson(){
		MyBean bean=new MyBean();
		bean.setId("001");
		bean.setName("银行卡");
		bean.setDate(new Date());
		java.util.List cardNum=new ArrayList<>();
		cardNum.add("农行");
		cardNum.add("工行");
		cardNum.add("建行");
		cardNum.add(new Person("test"));
		bean.setCardNum(cardNum);
		JSONObject jsonObject=JSONObject.fromObject(bean);
		System.out.println(jsonObject);
	}
	@Test
	   public void testArrayToJSON(){  
        boolean[] boolArray = new boolean[]{true,false,true};    
        JSONArray jsonArray = JSONArray.fromObject( boolArray );    
        System.out.println( jsonArray );    
    }
	
	   @Test  
	    public void testListToJSON(){  
	        java.util.List list = new ArrayList();    
	        list.add( "first" );  
	        list.add( "second" );  
	        JSONArray jsonArray = JSONArray.fromObject( list );    
	        System.out.println( jsonArray );    
	        // prints ["first","second"]    
	    } 
	    @Test  
	    public void testJsonToObject() throws Exception{  
	        String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";    
	        JSONObject jsonObject = JSONObject.fromObject( json );   
	        System.out.println(jsonObject);  
	        Object bean = JSONObject.toBean( jsonObject );   
	        assertEquals( jsonObject.get( "name" ), PropertyUtils.getProperty( bean, "name" ) );    
	        assertEquals( jsonObject.get( "bool" ), PropertyUtils.getProperty( bean, "bool" ) );    
	        assertEquals( jsonObject.get( "int" ), PropertyUtils.getProperty( bean, "int" ) );    
	        assertEquals( jsonObject.get( "double" ), PropertyUtils.getProperty( bean, "double" ) );    
	        assertEquals( jsonObject.get( "func" ), PropertyUtils.getProperty( bean, "func" ) );    
	        System.out.println(PropertyUtils.getProperty(bean, "name"));  
	        System.out.println(PropertyUtils.getProperty(bean, "bool"));  
	        System.out.println(PropertyUtils.getProperty(bean, "int"));  
	        System.out.println(PropertyUtils.getProperty(bean, "double"));  
	        System.out.println(PropertyUtils.getProperty(bean, "func"));  
	        System.out.println(PropertyUtils.getProperty(bean, "array"));  
	          
	        java.util.List arrayList = (java.util.List)JSONArray.toCollection(jsonObject.getJSONArray("array"));  
	        for(Object object : arrayList){  
	            System.out.println(object);  
	        }  
	          
	    }
	   
	
	
}
