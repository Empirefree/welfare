package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.User;

public class UserDynaSqlProvider {

	// 动态查询
	public String selectUser(User user){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "user" );
				if(user != null){
					if(user.getId() != null && !user.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE(" username LIKE CONCAT ('%',#{username},'%') ");
					}
					if(user.getPassword() != null && !user.getPassword().equals("")){
						WHERE(" password LIKE CONCAT ('%',#{password},'%') ");
					}
					if(user.getActualname() != null && !user.getActualname().equals("")){
						WHERE(" actualname LIKE CONCAT ('%',#{actualname},'%') ");
					}
					if(user.getSex() != null && !user.getSex().equals("")){
						WHERE(" sex LIKE CONCAT ('%',#{sex},'%') ");
					}
					if(user.getProvince() != null && !user.getProvince().equals("")){
						WHERE(" province LIKE CONCAT ('%',#{province},'%') ");
					}
					if(user.getCity() != null && !user.getCity().equals("")){
						WHERE(" city LIKE CONCAT ('%',#{city},'%') ");
					}
					if(user.getAddress() != null && !user.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{address},'%') ");
					}
					if(user.getPhone() != null && !user.getPhone().equals("")){
						WHERE(" phone LIKE CONCAT ('%',#{phone},'%') ");
					}
					if(user.getEmail() != null && !user.getEmail().equals("")){
						WHERE(" email LIKE CONCAT ('%',#{email},'%') ");
					}
					if(user.getIntroduce() != null && !user.getIntroduce().equals("")){
						WHERE(" introduce LIKE CONCAT ('%',#{introduce},'%') ");
					}
					if(user.getIdentity() != null && !user.getIdentity().equals("")){
						WHERE(" identity LIKE CONCAT ('%',#{identity},'%') ");
					}
					if(user.getIsActualname() != null && !user.getIsActualname().equals("")){
						WHERE(" i_actualname LIKE CONCAT ('%',#{isActualname},'%') ");
					}
					if(user.getCreatetime() != null && !user.getCreatetime().equals("")){
						WHERE(" createtime LIKE CONCAT ('%',#{createtime},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertUser(User user){

		return new SQL(){
			{
				INSERT_INTO( "user" );
				if(user.getId() != null && !user.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(user.getUsername() != null && !user.getUsername().equals("")){
					VALUES(" username", "#{username}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES(" password", "#{password}");
				}
				if(user.getActualname() != null && !user.getActualname().equals("")){
					VALUES(" actualname", "#{actualname}");
				}
				if(user.getSex() != null && !user.getSex().equals("")){
					VALUES(" sex", "#{sex}");
				}
				if(user.getProvince() != null && !user.getProvince().equals("")){
					VALUES(" province", "#{province}");
				}
				if(user.getCity() != null && !user.getCity().equals("")){
					VALUES(" city", "#{city}");
				}
				if(user.getAddress() != null && !user.getAddress().equals("")){
					VALUES(" address", "#{address}");
				}
				if(user.getPhone() != null && !user.getPhone().equals("")){
					VALUES(" phone", "#{phone}");
				}
				if(user.getEmail() != null && !user.getEmail().equals("")){
					VALUES(" email", "#{email}");
				}
				if(user.getIntroduce() != null && !user.getIntroduce().equals("")){
					VALUES(" introduce", "#{introduce}");
				}
				if(user.getIdentity() != null && !user.getIdentity().equals("")){
					VALUES(" identity", "#{identity}");
				}
				if(user.getIsActualname() != null && !user.getIsActualname().equals("")){
					VALUES(" i_actualname", "#{isActualname}");
				}
				if(user.getCreatetime() != null && !user.getCreatetime().equals("")){
					VALUES(" createtime", "#{createtime}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateUser(User user){
		System.out.println("\n动态更新");
		return new SQL(){
			{
				UPDATE( "user" );
				if(user.getId() != null && !user.getId().equals("")){
					SET(" id= #{id}");
				}
				if(user.getUsername() != null && !user.getUsername().equals("")){
					SET(" username= #{username}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					SET(" password= #{password}");
				}
				if(user.getActualname() != null && !user.getActualname().equals("")){
					SET(" actualname= #{actualname}");
				}
				if(user.getSex() != null && !user.getSex().equals("")){
					SET(" sex= #{sex}");
				}
				if(user.getProvince() != null && !user.getProvince().equals("")){
					SET(" province= #{province}");
				}
				if(user.getCity() != null && !user.getCity().equals("")){
					SET(" city= #{city}");
				}
				if(user.getAddress() != null && !user.getAddress().equals("")){
					SET(" address= #{address}");
				}
				if(user.getPhone() != null && !user.getPhone().equals("")){
					SET(" phone= #{phone}");
				}
				if(user.getEmail() != null && !user.getEmail().equals("")){
					SET(" email= #{email}");
				}
				if(user.getIntroduce() != null && !user.getIntroduce().equals("")){
					SET(" introduce= #{introduce}");
				}
				if(user.getIdentity() != null && !user.getIdentity().equals("")){
					SET(" identity= #{identity}");
				}
				if(user.getIsActualname() != null && !user.getIsActualname().equals("")){
					SET(" is_actualname= #{isActualname}");
				}
				if(user.getCreatetime() != null && !user.getCreatetime().equals("")){
					SET(" createtime= #{createtime}");
				}
				WHERE(" id = #{id} ");
			}
			
		}.toString();
	}

}