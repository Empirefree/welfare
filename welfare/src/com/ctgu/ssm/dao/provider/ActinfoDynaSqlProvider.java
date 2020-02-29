package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Actinfo;

public class ActinfoDynaSqlProvider {
    
    // 动态查询
    public String selectActinfo(Actinfo actinfo){
        
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM( "actinfo" );
                if(actinfo != null){
                    if(actinfo.getId() != null && !actinfo.getId().equals("")){
                        WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
                    }
                    if(actinfo.getActid() != null && !actinfo.getActid().equals("")){
                        WHERE(" actid LIKE CONCAT ('%',#{actid},'%') ");
                    }
                    if(actinfo.getUserid() != null && !actinfo.getUserid().equals("")){
                        WHERE(" userid LIKE CONCAT ('%',#{userid},'%') ");
                    }
                    if(actinfo.getAuditid() != null && !actinfo.getAuditid().equals("")){
                        WHERE(" auditid LIKE CONCAT ('%',#{auditid},'%') ");
                    }
                    if(actinfo.getActimg() != null && !actinfo.getActimg().equals("")){
                        WHERE(" actimg LIKE CONCAT ('%',#{actimg},'%') ");
                    }
                    if(actinfo.getName() != null && !actinfo.getName().equals("")){
                        WHERE(" name LIKE CONCAT ('%',#{name},'%') ");
                    }
                    if(actinfo.getIntroduce() != null && !actinfo.getIntroduce().equals("")){
                        WHERE(" introduce LIKE CONCAT ('%',#{introduce},'%') ");
                    }
                    if(actinfo.getActtypeid() != null && !actinfo.getActtypeid().equals("")){
                        WHERE(" acttypeid LIKE CONCAT ('%',#{acttypeid},'%') ");
                    }
                    if(actinfo.getStarttime() != null && !actinfo.getStarttime().equals("")){
                        WHERE(" starttime LIKE CONCAT ('%',#{starttime},'%') ");
                    }
                    if(actinfo.getEndtime() != null && !actinfo.getEndtime().equals("")){
                        WHERE(" endtime LIKE CONCAT ('%',#{endtime},'%') ");
                    }
                }
            }
        }.toString();
        
        return sql;
    }
    
    // 动态插入
    public String insertActinfo(Actinfo actinfo){
        
        return new SQL(){
            {
                INSERT_INTO( "actinfo" );
                if(actinfo.getId() != null && !actinfo.getId().equals("")){
                    VALUES(" id", "#{id}");
                }
                if(actinfo.getActid() != null && !actinfo.getActid().equals("")){
                    VALUES(" actid", "#{actid}");
                }
                if(actinfo.getUserid() != null && !actinfo.getUserid().equals("")){
                    VALUES(" userid", "#{userid}");
                }
                if(actinfo.getAuditid() != null && !actinfo.getAuditid().equals("")){
                    VALUES(" auditid", "#{auditid}");
                }
                if(actinfo.getActimg() != null && !actinfo.getActimg().equals("")){
                    VALUES(" actimg", "#{actimg}");
                }
                if(actinfo.getName() != null && !actinfo.getName().equals("")){
                    VALUES(" name", "#{name}");
                }
                if(actinfo.getIntroduce() != null && !actinfo.getIntroduce().equals("")){
                    VALUES(" introduce", "#{introduce}");
                }
                if(actinfo.getActtypeid() != null && !actinfo.getActtypeid().equals("")){
                    VALUES(" acttypeid", "#{acttypeid}");
                }
                if(actinfo.getStarttime() != null && !actinfo.getStarttime().equals("")){
                    VALUES(" starttime", "#{starttime}");
                }
                if(actinfo.getEndtime() != null && !actinfo.getEndtime().equals("")){
                    VALUES(" endtime", "#{endtime}");
                }
            }
        }.toString();
    }
    
    // 动态更新
    public String updateActinfo(Actinfo actinfo){
        
        return new SQL(){
            {
                UPDATE( "actinfo" );
                if(actinfo.getId() != null && !actinfo.getId().equals("")){
                    SET(" id= #{id}");
                }
                if(actinfo.getActid() != null && !actinfo.getActid().equals("")){
                    SET(" actid= #{actid}");
                }
                if(actinfo.getUserid() != null && !actinfo.getUserid().equals("")){
                    SET(" userid= #{userid}");
                }
                if(actinfo.getAuditid() != null && !actinfo.getAuditid().equals("")){
                    SET(" auditid= #{auditid}");
                }
                if(actinfo.getActimg() != null && !actinfo.getActimg().equals("")){
                    SET(" actimg= #{actimg}");
                }
                if(actinfo.getName() != null && !actinfo.getName().equals("")){
                    SET(" name= #{name}");
                }
                if(actinfo.getIntroduce() != null && !actinfo.getIntroduce().equals("")){
                    SET(" introduce= #{introduce}");
                }
                if(actinfo.getActtypeid() != null && !actinfo.getActtypeid().equals("")){
                    SET(" acttypeid= #{acttypeid}");
                }
                if(actinfo.getStarttime() != null && !actinfo.getStarttime().equals("")){
                    SET(" starttime= #{starttime}");
                }
                if(actinfo.getEndtime() != null && !actinfo.getEndtime().equals("")){
                    SET(" endtime= #{endtime}");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }
    
}
