package model;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.springframework.format.annotation.DateTimeFormat;
 
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user_table")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;
	
	@Column(name = "user_name")
    private String userName;
 
    @Column(name = "user_email")
    private String userEmail;
 
    @Column(name = "user_phoneNo")
    private long userPhoneNo;
 
    @Column(name = "user_dob")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date userDob;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(long userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public Date getUserDob() {
		return userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}
    
	@Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhoneNo="
                + userPhoneNo + ", userDob=" + userDob + "]";
    }
}
