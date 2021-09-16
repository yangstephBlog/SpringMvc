package cn.yangjc.rest.pojo;


public class Employee {

    /**
     * 工号
     */
    private Integer eid;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 员工级别
     */
    private String level;
    /**
     * 性别（1：男，2：女）
     */
    private Integer gender;

    public Employee() {}

    public Employee(Integer eid, String userName, String level, Integer gender) {
        this.eid = eid;
        this.userName = userName;
        this.level = level;
        this.gender = gender;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", userName='" + userName + '\'' +
                ", level='" + level + '\'' +
                ", gender=" + gender +
                '}';
    }
}
