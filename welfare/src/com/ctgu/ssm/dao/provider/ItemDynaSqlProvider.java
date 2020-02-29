package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Item;

public class ItemDynaSqlProvider {

	// 动态查询
	public String selectItem(Item item){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "item" );
				if(item != null){
					if(item.getId() != null && !item.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(item.getItemname() != null && !item.getItemname().equals("")){
						WHERE(" itemname LIKE CONCAT ('%',#{itemname},'%') ");
					}
					if(item.getItemimg() != null && !item.getItemimg().equals("")){
						WHERE(" itemimg LIKE CONCAT ('%',#{itemimg},'%') ");
					}
					if(item.getItemcount() != null && !item.getItemcount().equals("")){
						WHERE(" itemcount LIKE CONCAT ('%',#{itemcount},'%') ");
					}
					if(item.getIntroduce() != null && !item.getIntroduce().equals("")){
						WHERE(" introduce LIKE CONCAT ('%',#{introduce},'%') ");
					}
					if(item.getUserid() != null && !item.getUserid().equals("")){
						WHERE(" userid LIKE CONCAT ('%',#{userid},'%') ");
					}
					if(item.getTypeid() != null && !item.getTypeid().equals("")){
						WHERE(" typeid LIKE CONCAT ('%',#{typeid},'%') ");
					}
					if(item.getAuditid() != null && !item.getAuditid().equals("")){
						WHERE(" auditid LIKE CONCAT ('%',#{auditid},'%') ");
					}
					if(item.getCreatetime() != null && !item.getCreatetime().equals("")){
						WHERE(" createtime LIKE CONCAT ('%',#{createtime},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertItem(Item item){

		return new SQL(){
			{
				INSERT_INTO( "item" );
				if(item.getId() != null && !item.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(item.getItemname() != null && !item.getItemname().equals("")){
					VALUES(" itemname", "#{itemname}");
				}
				if(item.getItemimg() != null && !item.getItemimg().equals("")){
					VALUES(" itemimg", "#{itemimg}");
				}
				if(item.getItemcount() != null && !item.getItemcount().equals("")){
					VALUES(" itemcount", "#{itemcount}");
				}
				if(item.getIntroduce() != null && !item.getIntroduce().equals("")){
					VALUES(" introduce", "#{introduce}");
				}
				if(item.getUserid() != null && !item.getUserid().equals("")){
					VALUES(" userid", "#{userid}");
				}
				if(item.getTypeid() != null && !item.getTypeid().equals("")){
					VALUES(" typeid", "#{typeid}");
				}
				if(item.getAuditid() != null && !item.getAuditid().equals("")){
					VALUES(" auditid", "#{auditid}");
				}
				if(item.getCreatetime() != null && !item.getCreatetime().equals("")){
					VALUES(" createtime", "#{createtime}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateItem(Item item){

		return new SQL(){
			{
				UPDATE( "item" );
				if(item.getId() != null && !item.getId().equals("")){
					SET(" id= #{id}");
				}
				if(item.getItemname() != null && !item.getItemname().equals("")){
					SET(" itemname= #{itemname}");
				}
				if(item.getItemimg() != null && !item.getItemimg().equals("")){
					SET(" itemimg= #{itemimg}");
				}
				if(item.getItemcount() != null && !item.getItemcount().equals("")){
					SET(" itemcount= #{itemcount}");
				}
				if(item.getIntroduce() != null && !item.getIntroduce().equals("")){
					SET(" introduce= #{introduce}");
				}
				if(item.getUserid() != null && !item.getUserid().equals("")){
					SET(" userid= #{userid}");
				}
				if(item.getTypeid() != null && !item.getTypeid().equals("")){
					SET(" typeid= #{typeid}");
				}
				if(item.getAuditid() != null && !item.getAuditid().equals("")){
					SET(" auditid= #{auditid}");
				}
				if(item.getCreatetime() != null && !item.getCreatetime().equals("")){
					SET(" createtime= #{createtime}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}