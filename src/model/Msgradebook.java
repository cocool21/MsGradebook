package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MSGRADEBOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Msgradebook.findAll", query="SELECT m FROM Msgradebook m")
public class Msgradebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ASSIGNMENT_ID")
	private long assignmentId;

	@Column(name="ASSIGNMENT_NAME")
	private String assignmentName;

	private BigDecimal grade;

	@Column(name="STUDENT_ID")
	private BigDecimal studentId;

	@Temporal(TemporalType.DATE)
	@Column(name="SUBMIT_DATE")
	private Date submitDate;

	@Column(name="\"TYPE\"")
	private String type;

	public Msgradebook() {
	}

	public long getAssignmentId() {
		return this.assignmentId;
	}

	public void setAssignmentId(long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentName() {
		return this.assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public BigDecimal getGrade() {
		return this.grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public BigDecimal getStudentId() {
		return this.studentId;
	}

	public void setStudentId(BigDecimal studentId) {
		this.studentId = studentId;
	}

	public Date getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}