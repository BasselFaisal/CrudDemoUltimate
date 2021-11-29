package com.crud.demo.model.user;

import com.crud.demo.model.hrchy.Hrchy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="gnr_usr")
public class User {

    @Id
    @Column(name="usr_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="usr_code")
    @NotNull(message = "User Code can't be empty.")
    private String userCode;

    @Column(name="usr_f_nm")
    private String userFirstname;

    @Column(name="usr_l_nm")
    @NotNull(message = "User last name can't be empty.")
    private String userLastname;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_no_mngr", nullable = true)
    private User mangerUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hrchy_code", nullable = false)
    private Hrchy hrchy;

    @Column(name="usr_pswrd")
    @NotNull(message = "User password can't be empty.")
    private String password;

    @Column(name="img_nm")
    private String image;

    @Column(name="f_date_effct")
    private Date fDateEffect;

    @Column(name="t_date_effct")
    private Date tDateEffect;

    @Column(name="f_time_effct")
    private Date fTimeEffect;

    @Column(name="t_time_effct")
    private Date tTimeEffect;

    @Column(name="e_mail")
    private String email;

    @Column(name="mobile_no")
    private String mobile;

    @Column(name="inactv_flg")
    @NotNull(message = "Inactive Flag can't be empty.")
    private boolean inactive;

    @Column(name="inactv_usr_no")
    private String inactiveNumber;

    @Column(name="inactv_date")
    private Date inactiveDate;

    @Column(name="inactv_dsc")
    private String inactiveDes ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public User getMangerUser() {
        return mangerUser;
    }

    public void setMangerUser(User mangerUser) {
        this.mangerUser = mangerUser;
    }

    public Hrchy getHrchy() {
        return hrchy;
    }

    public void setHrchy(Hrchy hrchy) {
        this.hrchy = hrchy;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getfDateEffect() {
        return fDateEffect;
    }

    public void setfDateEffect(Date fDateEffect) {
        this.fDateEffect = fDateEffect;
    }

    public Date gettDateEffect() {
        return tDateEffect;
    }

    public void settDateEffect(Date tDateEffect) {
        this.tDateEffect = tDateEffect;
    }

    public Date getfTimeEffect() {
        return fTimeEffect;
    }

    public void setfTimeEffect(Date fTimeEffect) {
        this.fTimeEffect = fTimeEffect;
    }

    public Date gettTimeEffect() {
        return tTimeEffect;
    }

    public void settTimeEffect(Date tTimeEffect) {
        this.tTimeEffect = tTimeEffect;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public String getInactiveNumber() {
        return inactiveNumber;
    }

    public void setInactiveNumber(String inactiveNumber) {
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
}
