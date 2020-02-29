package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Leaveidea;

public class LeaveideaDynaSqlProvider {

	// 动态查询
	public String selectLeaveidea(Leaveidea leaveidea){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "leaveidea" );
				if(leaveidea != null){
					if(leaveidea.getId() != null && !leaveidea.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(leaveidea.getIdeaid() != null && !leaveidea.getIdeaid().equals("")){
						WHERE(" ideaid LIKE CONCAT ('%',#{ideaid},'%') ");
					}
					if(leaveidea.getUser1id() != null && !leaveidea.getUser1id().equals("")){
						WHERE(" user1id LIKE CONCAT ('%',#{user1id},'%') ");
					}
					if(leaveidea.getComment() != null && !leaveidea.getComment().equals("")){
						WHERE(" comment LIKE CONCAT ('%',#{comment},'%') ");
					}
					if(leaveidea.getIsSolve() != null && !leaveidea.getIsSolve().equals("")){
						WHERE(" is_solve LIKE CONCAT ('%',#{isSolve},'%') ");
					}
					if(leaveidea.getCreatetime() != null && !leaveidea.getCreatetime().equals("")){
						WHERE(" createtime LIKE CONCAT ('%',#{createtime},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertLeaveidea(Leaveidea leaveidea){

		return new SQL(){
			{
				INSERT_INTO( "leaveidea" );
				if(leaveidea.getId() != null && !leaveidea.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(leaveidea.getIdeaid() != null && !leaveidea.getIdeaid().equals("")){
					VALUES(" ideaid", "#{ideaid}");
				}
				if(leaveidea.getUser1id() != null && !leaveidea.getUser1id().equals("")){
					VALUES(" user1id", "#{user1id}");
				}
				if(leaveidea.getComment() != null && !leaveidea.getComment().equals("")){
					VALUES(" comment", "#{comment}");
				}
				if(leaveidea.getIsSolve() != null && !leaveidea.getIsSolve().equals("")){
					VALUES(" is_solve", "#{isSolve}");
				}
				if(leaveidea.getCreatetime() != null && !leaveidea.getCreatetime().equals("")){
					VALUES(" createtime", "#{createtime}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateLeaveidea(Leaveidea leaveidea){

		return new SQL(){
			{
				UPDATE( "leaveidea" );
				if(leaveidea.getId() != null && !leaveidea.getId().equals("")){
					SET(" id= #{id}");
				}
				if(leaveidea.getIdeaid() != null && !leaveidea.getIdeaid().equals("")){
					SET(" ideaid= #{ideaid}");
				}
				if(leaveidea.getUser1id() != null && !leaveidea.getUser1id().equals("")){
					SET(" user1id= #{user1id}");
				}
				if(leaveidea.getComment() != null && !leaveidea.getComment().equals("")){
					SET(" comment= #{comment}");
				}
				if(leaveidea.getIsSolve() != null && !leaveidea.getIsSolve().equals("")){
					SET(" is_solve= #{isSolve}");
				}
				if(leaveidea.getCreatetime() != null && !leaveidea.getCreatetime().equals("")){
					SET(" createtime= #{createtime}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}