package com.ctgu.ssm.entity;

public class Offinfo {
    
    
    private Integer id;
    private Integer actid;
    private Integer userid;
    private String actimg;
    private String name;
    private String introduce;
    private String acttypeid;
    private String starttime;
    private String endtime;
    
    public Offinfo(){
    }
    public Offinfo(Integer id, Integer actid, Integer userid, String actimg, String name, String introduce, String acttypeid, String starttime, String endtime) {
        super();this.id = id;
        this.actid = actid;
        this.userid = userid;
        this.actimg = actimg;
        this.name = name;
        this.introduce = introduce;
        this.acttypeid = acttypeid;
        this.starttime = starttime;
        this.endtime = endtime;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getActid() {
        return actid;
    }
    public void setActid(Integer actid){
        this.actid = actid;
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid){
        this.userid = userid;
    }
    public String getActimg() {
        return actimg;
    }
    public void setActimg(String actimg){
        this.actimg = actimg;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce){
        this.introduce = introduce;
    }
    public String getActtypeid() {
        return acttypeid;
    }
    public void setActtypeid(String acttypeid){
        this.acttypeid = acttypeid;
    }
    public String getStarttime() {
        return starttime;
    }
    public void setStarttime(String starttime){
        this.starttime = starttime;
    }
    public String getEndtime() {
        return endtime;
    }
    public void setEndtime(String endtime){
        this.endtime = endtime;
    }
    @Override
    public String toString() {
        return"offinfo [id=" + id+ ", actid=" +actid+ ", userid=" +userid+ ", actimg=" +actimg+ ", name=" +name+ ", introduce=" +introduce+ ", acttypeid=" +acttypeid+ ", starttime=" +starttime+ ", endtime=" +endtime + "]";
    }
}
