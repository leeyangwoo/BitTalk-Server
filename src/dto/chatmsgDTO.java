package dto;

import java.sql.Timestamp;
import java.util.Date;

public class ChatmsgDTO {
	private int cmno;
	private int crno;
	private int senderno;
	private String msg;
	private Timestamp sendtime;
	public int getCmno() {
		return cmno;
	}
	public void setCmno(int cmno) {
		this.cmno = cmno;
	}
	public int getCrno() {
		return crno;
	}
	public void setCrno(int crno) {
		this.crno = crno;
	}
	public int getSenderno() {
		return senderno;
	}
	public void setSenderno(int senderno) {
		this.senderno = senderno;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}
	
}
