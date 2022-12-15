package hajarshaufi.ftmk.com;

import java.io.Serializable;

public class User implements Serializable {
    private String strFullName, strPwd, strAddress, strEmail, strBirthdate, strGender;

    public User(String strFullName, String strPwd, String strAddress, String strEmail,
                String strBirthdate, String strGender) {
        this.strFullName = strFullName;
        this.strPwd = strPwd;
        this.strAddress = strAddress;
        this.strEmail = strEmail;
        this.strBirthdate = strBirthdate;
        this.strGender = strGender;
    }

    public String getStrFullName() {
        return strFullName;
    }

    public void setStrFullName(String strFullName) {
        this.strFullName = strFullName;
    }

    public String getStrPwd() {
        return strPwd;
    }

    public void setStrPwd(String strPwd) {
        this.strPwd = strPwd;
    }

    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrBirthdate() {
        return strBirthdate;
    }

    public void setStrBirthdate(String strBirthdate) {
        this.strBirthdate = strBirthdate;
    }

    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }
}
