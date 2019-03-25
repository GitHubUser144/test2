package com.bean;

import java.io.Serializable;


import org.springframework.stereotype.Repository;
//@Repository("checi")
public class Checi implements Serializable
{
	private int id;
	private String shifazhan;
	private String daodazhan;
	private String piaoshijian;
	private String startshijian;
	private String endshijian;
	private String ctype;
	private int piaojia;
	private int piaoshu;
	private String del;
	
	public Checi() {
		super();
	}

	public Checi(int id, String shifazhan,String daodazhan, String piaoshijian, String startshijian, String endshijian, String ctype,
			int piaojia, int piaoshu, String del) {
		super();
		this.id = id;
		this.shifazhan = shifazhan;
		this.daodazhan = daodazhan;
		this.piaoshijian = piaoshijian;
		this.startshijian = startshijian;
		this.endshijian = endshijian;
		this.ctype = ctype;
		this.piaojia = piaojia;
		this.piaoshu = piaoshu;
		this.del = del;
	}

	public String getDaodazhan() {
		return daodazhan;
	}

	public void setDaodazhan(String daodazhan) {
		this.daodazhan = daodazhan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShifazhan() {
		return shifazhan;
	}

	public void setShifazhan(String shifazhan) {
		this.shifazhan = shifazhan;
	}

	public String getPiaoshijian() {
		return piaoshijian;
	}

	public void setPiaoshijian(String piaoshijian) {
		this.piaoshijian = piaoshijian;
	}

	public String getStartshijian() {
		return startshijian;
	}

	public void setStartshijian(String startshijian) {
		this.startshijian = startshijian;
	}

	public String getEndshijian() {
		return endshijian;
	}

	public void setEndshijian(String endshijian) {
		this.endshijian = endshijian;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public int getPiaojia() {
		return piaojia;
	}

	public void setPiaojia(int piaojia) {
		this.piaojia = piaojia;
	}

	public int getPiaoshu() {
		return piaoshu;
	}

	public void setPiaoshu(int piaoshu) {
		this.piaoshu = piaoshu;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "Checi [id=" + id + ", shifazhan=" + shifazhan + ", daodazhan=" + daodazhan + ", piaoshijian="
				+ piaoshijian + ", startshijian=" + startshijian + ", endshijian=" + endshijian + ", ctype=" + ctype
				+ ", piaojia=" + piaojia + ", piaoshu=" + piaoshu + ", del=" + del + "]";
	}

	
	
}
