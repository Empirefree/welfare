package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Support;

public class SupportDynaSqlProvider {

	// 动态查询
	public String selectSupport(Support support){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "support" );
				if(support != null){
					if(support.getId() != null && !support.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(support.getDonorid() != null && !support.getDonorid().equals("")){
						WHERE(" donorid LIKE CONCAT ('%',#{donorid},'%') ");
					}
					if(support.getItemid() != null && !support.getItemid().equals("")){
						WHERE(" itemid = #{itemid}");
					}
					if(support.getItemnum() != null && !support.getItemnum().equals("")){
						WHERE(" itemnum LIKE CONCAT ('%',#{itemnum},'%') ");
					}
					if(support.getReceiveid() != null && !support.getReceiveid().equals("")){
						WHERE(" receiveid LIKE CONCAT ('%',#{receiveid},'%') ");
					}
					if(support.getRemarks() != null && !support.getRemarks().equals("")){
						WHERE(" remarks LIKE CONCAT ('%',#{remarks},'%') ");
					}
					if(support.getDistin() != null && !support.getDistin().equals("")){
						WHERE(" distin LIKE CONCAT ('%',#{distin},'%') ");
					}
					if(support.getCreatetime() != null && !support.getCreatetime().equals("")){
						WHERE(" createtime LIKE CONCAT ('%',#{createtime},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertSupport(Support support){

		return new SQL(){
			{
				INSERT_INTO( "support" );
				if(support.getId() != null && !support.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(support.getDonorid() != null && !support.getDonorid().equals("")){
					VALUES(" donorid", "#{donorid}");
				}
				if(support.getItemid() != null && !support.getItemid().equals("")){
					VALUES(" itemid", "#{itemid}");
				}
				if(support.getItemnum() != null && !support.getItemnum().equals("")){
					VALUES(" itemnum", "#{itemnum}");
				}
				if(support.getReceiveid() != null && !support.getReceiveid().equals("")){
					VALUES(" receiveid", "#{receiveid}");
				}
				if(support.getRemarks() != null && !support.getRemarks().equals("")){
					VALUES(" remarks", "#{remarks}");
				}
				if(support.getDistin() != null && !support.getDistin().equals("")){
					VALUES(" distin", "#{distin}");
				}
				if(support.getCreatetime() != null && !support.getCreatetime().equals("")){
					VALUES(" createtime", "#{createtime}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateSupport(Support support){

		return new SQL(){
			{
				UPDATE( "support" );
				if(support.getId() != null && !support.getId().equals("")){
					SET(" id= #{id}");
				}
				if(support.getDonorid() != null && !support.getDonorid().equals("")){
					SET(" donorid= #{donorid}");
				}
				if(support.getItemid() != null && !support.getItemid().equals("")){
					SET(" itemid= #{itemid}");
				}
				if(support.getItemnum() != null && !support.getItemnum().equals("")){
					SET(" itemnum= #{itemnum}");
				}
				if(support.getReceiveid() != null && !support.getReceiveid().equals("")){
					SET(" receiveid= #{receiveid}");
				}
				if(support.getRemarks() != null && !support.getRemarks().equals("")){
					SET(" remarks= #{remarks}");
				}
				if(support.getDistin() != null && !support.getDistin().equals("")){
					SET(" distin= #{distin}");
				}
				if(support.getCreatetime() != null && !support.getCreatetime().equals("")){
					SET(" createtime= #{createtime}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}