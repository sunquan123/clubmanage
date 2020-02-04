package com.clubmanage.ClubDemo.Pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.*;

public class Club {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "不能为空！")
    private String name;
    @NotEmpty(message = "不能为空！")
    private String manager;

    private Integer type;
    @NotNull(message = "不能为空！")
    private Date createDate;
    @Min(value = 1,message = "不能小于等于0！")
    private Integer activitytimes;
    @Min(value = 1,message = "不能小于等于0！")
    private Integer membercount;
    private String remarks;

    public Club() {
    }

    public Club(String name, String manager, int type, Date createDate, int activitytimes, int membercount, String remarks) {
        this.name = name;
        this.manager = manager;
        this.type = type;
        this.createDate = createDate;
        this.activitytimes = activitytimes;
        this.membercount = membercount;
        this.remarks = remarks;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getActivitytimes() {
        return activitytimes;
    }

    public void setActivitytimes(int activitytimes) {
        this.activitytimes = activitytimes;
    }

    public Integer getMembercount() {
        return membercount;
    }

    public void setMembercount(int membercount) {
        this.membercount = membercount;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", type=" + type +
                ", createDate=" + createDate +
                ", activitytimes=" + activitytimes +
                ", membercount=" + membercount +
                '}';
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
