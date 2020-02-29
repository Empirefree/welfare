package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Interactive;

public class InteractiveDynaSqlProvider {

	// 动态查询
	public String selectInteractive(Interactive interactive){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "interactive" );
				if(interactive != null){
					if(interactive.getId() != null && !interactive.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(interactive.getItemid() != null && !interactive.getItemid().equals("")){
						WHERE(" itemid LIKE CONCAT ('%',#{itemid},'%') ");
					}
					if(interactive.getDonorid() != null && !interactive.getDonorid().equals("")){
						WHERE(" donorid LIKE CONCAT ('%',#{donorid},'%') ");
					}
					if(interactive.getReceiveid() != null && !interactive.getReceiveid().equals("")){
						WHERE(" receiveid LIKE CONCAT ('%',#{receiveid},'%') ");
					}
					if(interactive.getContent() != null && !interactive.getContent().equals("")){
						WHERE(" content LIKE CONCAT ('%',#{content},'%') ");
					}
					if(interactive.getDistin() != null && !interactive.getDistin().equals("")){
						WHERE(" distin LIKE CONCAT ('%',#{distin},'%') ");
					}
					if(interactive.getCreatetime() != null && !interactive.getCreatetime().equals("")){
						WHERE(" createtime LIKE CONCAT ('%',#{createtime},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertInteractive(Interactive interactive){

		return new SQL(){
			{
				INSERT_INTO( "interactive" );
				if(interactive.getId() != null && !interactive.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(interactive.getItemid() != null && !interactive.getItemid().equals("")){
					VALUES(" itemid", "#{itemid}");
				}
				if(interactive.getDonorid() != null && !interactive.getDonorid().equals("")){
					VALUES(" donorid", "#{donorid}");
				}
				if(interactive.getReceiveid() != null && !interactive.getReceiveid().equals("")){
					VALUES(" receiveid", "#{receiveid}");
				}
				if(interactive.getContent() != null && !interactive.getContent().equals("")){
					VALUES(" content", "#{content}");
				}
				if(interactive.getDistin() != null && !interactive.getDistin().equals("")){
					VALUES(" distin", "#{distin}");
				}
				if(interactive.getCreatetime() != null && !interactive.getCreatetime().equals("")){
					VALUES(" createtime", "#{createtime}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateInteractive(Interactive interactive){

		return new SQL(){
			{
				UPDATE( "interactive" );
				if(interactive.getId() != null && !interactive.getId().equals("")){
					SET(" id= #{id}");
				}
				if(interactive.getItemid() != null && !interactive.getItemid().equals("")){
					SET(" itemid= #{itemid}");
				}
				if(interactive.getDonorid() != null && !interactive.getDonorid().equals("")){
					SET(" donorid= #{donorid}");
				}
				if(interactive.getReceiveid() != null && !interactive.getReceiveid().equals("")){
					SET(" receiveid= #{receiveid}");
				}
				if(interactive.getContent() != null && !interactive.getContent().equals("")){
					SET(" content= #{content}");
				}
				if(interactive.getDistin() != null && !interactive.getDistin().equals("")){
					SET(" distin= #{distin}");
				}
				if(interactive.getCreatetime() != null && !interactive.getCreatetime().equals("")){
					SET(" createtime= #{createtime}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}