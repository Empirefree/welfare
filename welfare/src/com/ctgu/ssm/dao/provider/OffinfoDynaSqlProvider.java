package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Offinfo;

public class OffinfoDynaSqlProvider {
    
    // 动态查询
    public String selectOffinfo(Offinfo offinfo){
        
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM( "offinfo" );
                if(offinfo != null){
                    if(offinfo.getId() != null && !offinfo.getId().equals("")){
                        WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
                    }
                    if(offinfo.getActid() != null && !offinfo.getActid().equals("")){
                        WHERE(" actid LIKE CONCAT ('%',#{actid},'%') ");
                    }
                    if(offinfo.getUserid() != null && !offinfo.getUserid().equals("")){
                        WHERE(" userid LIKE CONCAT ('%',#{userid},'%') ");
                    }
                    if(offinfo.getActimg() != null && !offinfo.getActimg().equals("")){
                        WHERE(" actimg LIKE CONCAT ('%',#{actimg},'%') ");
                    }
                    if(offinfo.getName() != null && !offinfo.getName().equals("")){
                        WHERE(" name LIKE CONCAT ('%',#{name},'%') ");
                    }
                    if(offinfo.getIntroduce() != null && !offinfo.getIntroduce().equals("")){
                        WHERE(" introduce LIKE CONCAT ('%',#{introduce},'%') ");
                    }
                    if(offinfo.getActtypeid() != null && !offinfo.getActtypeid().equals("")){
                        WHERE(" acttypeid LIKE CONCAT ('%',#{acttypeid},'%') ");
                    }
                    if(offinfo.getStarttime() != null && !offinfo.getStarttime().equals("")){
                        WHERE(" starttime LIKE CONCAT ('%',#{starttime},'%') ");
                    }
                    if(offinfo.getEndtime() != null && !offinfo.getEndtime().equals("")){
                        WHERE(" endtime LIKE CONCAT ('%',#{endtime},'%') ");
                    }
                }
            }
        }.toString();
        
        return sql;
    }
    
    // 动态插入
    public String insertOffinfo(Offinfo offinfo){
        
        return new SQL(){
            {
                INSERT_INTO( "offinfo" );
                if(offinfo.getId() != null && !offinfo.getId().equals("")){
                    VALUES(" id", "#{id}");
                }
                if(offinfo.getActid() != null && !offinfo.getActid().equals("")){
                    VALUES(" actid", "#{actid}");
                }
                if(offinfo.getUserid() != null && !offinfo.getUserid().equals("")){
                    VALUES(" userid", "#{userid}");
                }
                if(offinfo.getActimg() != null && !offinfo.getActimg().equals("")){
                    VALUES(" actimg", "#{actimg}");
                }
                if(offinfo.getName() != null && !offinfo.getName().equals("")){
                    VALUES(" name", "#{name}");
                }
                if(offinfo.getIntroduce() != null && !offinfo.getIntroduce().equals("")){
                    VALUES(" introduce", "#{introduce}");
                }
                if(offinfo.getActtypeid() != null && !offinfo.getActtypeid().equals("")){
                    VALUES(" acttypeid", "#{acttypeid}");
                }
                if(offinfo.getStarttime() != null && !offinfo.getStarttime().equals("")){
                    VALUES(" starttime", "#{starttime}");
                }
                if(offinfo.getEndtime() != null && !offinfo.getEndtime().equals("")){
                    VALUES(" endtime", "#{endtime}");
                }
            }
        }.toString();
    }
    
    // 动态更新
    public String updateOffinfo(Offinfo offinfo){
        
        return new SQL(){
            {
                UPDATE( "offinfo" );
                if(offinfo.getId() != null && !offinfo.getId().equals("")){
                    SET(" id= #{id}");
                }
                if(offinfo.getActid() != null && !offinfo.getActid().equals("")){
                    SET(" actid= #{actid}");
                }
                if(offinfo.getUserid() != null && !offinfo.getUserid().equals("")){
                    SET(" userid= #{userid}");
                }
                if(offinfo.getActimg() != null && !offinfo.getActimg().equals("")){
                    SET(" actimg= #{actimg}");
                }
                if(offinfo.getName() != null && !offinfo.getName().equals("")){
                    SET(" name= #{name}");
                }
                if(offinfo.getIntroduce() != null && !offinfo.getIntroduce().equals("")){
                    SET(" introduce= #{introduce}");
                }
                if(offinfo.getActtypeid() != null && !offinfo.getActtypeid().equals("")){
                    SET(" acttypeid= #{acttypeid}");
                }
                if(offinfo.getStarttime() != null && !offinfo.getStarttime().equals("")){
                    SET(" starttime= #{starttime}");
                }
                if(offinfo.getEndtime() != null && !offinfo.getEndtime().equals("")){
                    SET(" endtime= #{endtime}");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }
    
}
