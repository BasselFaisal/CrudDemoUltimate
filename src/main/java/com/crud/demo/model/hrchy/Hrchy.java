package com.crud.demo.model.hrchy;

import com.crud.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="gnr_hrchy")
public class Hrchy {

    @Id
    @Column(name="hrchy_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="hrchy_f_nm")
    private String firstname;

    @Column(name="hrchy_l_nm")
    private String lastname;

    @OneToOne
    @JoinColumn(name="hrchy_code_parnt", nullable = true)
    private Hrchy parentCode;

    @Column(name="hrchy_typ")
    private int type;

    @Column(name="lvl_no")
    private String levelNumber;

    @Column(name="inactv_flg ")
    private boolean inactive;

    @Column(name="inactv_usr_no")
    private int inactiveNumber;

    @Column(name="inactv_date")
    private Date inactiveDate;

    @Column(name="inactv_dsc")
    private String inactiveDes;

//    @OneToOne(mappedBy = "hrchy", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Hrchy getParentCode() {
        return parentCode;
    }

    public void setParentCode(Hrchy parentCode) {
        this.parentCode = parentCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public int getInactiveNumber() {
        return inactiveNumber;
    }

    public void setInactiveNumber(int inactiveNumber) {
        this.inactiveNumber = inactiveNumber;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getInactiveDes() {
        return inactiveDes;
    }

    public void setInactiveDes(String inactiveDes) {
        this.inactiveDes = inactiveDes;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
