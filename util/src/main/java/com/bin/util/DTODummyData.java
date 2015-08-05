package com.bin.util;

import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTODummyData {

	public static List<UserDTO> badges;
	
	static{
		try {
			badges = getList(100);
		} catch (InstantiationException | IllegalAccessException
				| NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	private static List<UserDTO> getList(int numberOfResults) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		String prefixValue = "Badge";
		
		List<UserDTO> list = new ArrayList<UserDTO>();  
		
		for(int i = 0; i < 100; i ++){
			
			UserDTO o = UserDTO.class.newInstance();
			
			for(Field f : UserDTO.class.getDeclaredFields()){
				
				String setMethodName = "set" + f.getName().replaceFirst(f.getName().substring(0, 1), f.getName().substring(0, 1).toUpperCase());
				//String getMethodName = "get" + f.getName().replaceFirst(f.getName().substring(0, 1), f.getName().substring(0, 1).toUpperCase());
				
				Method setMethod = UserDTO.class.getMethod(setMethodName , new Class[]{f.getType()});
				//Method getMethod = UserDTO.class.getMethod(getMethodName , new Class[]{});
				
				if( f.getType().equals(Integer.class) 
						|| f.getType().equals(Float.class)
						|| f.getType().equals(Number.class)){
					setMethod.invoke(o, 0);
				}
				
				else if( f.getType().equals(Double.class) ){
					setMethod.invoke(o, 0.0);
				}
				
				else if( f.getType().equals(String.class) ){
					setMethod.invoke(o, prefixValue + 0);
				}
				
				else if( f.getType().equals(Date.class) ){
					setMethod.invoke(o, new Date());
				}
				
				else if( f.getType().equals(Boolean.class) ){
					setMethod.invoke(o, i % 2 == 0);
				}
			}
			list.add(o);
		}
		
		return list;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		
		List<UserDTO> list = getList(10); 
		
		for(UserDTO dto : list){
			out.println(dto.getName());
		}
		
	}
	
	
}

class UserDTO {
	
	private Integer id;
	private Boolean active;
	private String name;
	private Date birthday;
	
	public UserDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
