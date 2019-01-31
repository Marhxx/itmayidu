package com.spring.common.entity;

import javax.persistence.*;

/**
 * china_street 实体类
 * Fri Mar 31 17:04:56 CST 2017 lcx
 */


@Entity
@Table(name = "china_street")
public class ChinaStreet implements java.io.Serializable {
    private Long sid;
    private String sname;
    private Long oid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", unique = true, nullable = false)
    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Column(name = "oid")
    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public ChinaStreet(Long sid, String sname, Long oid) {
        this.sid = sid;
        this.sname = sname;
        this.oid = oid;
    }

    public ChinaStreet() {
    }
}

