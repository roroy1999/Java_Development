package com.robin.DemoHib;

import javax.persistence.Embeddable;

@Embeddable
public class AlienName {
	
	private String fName;
	private String lName;
	private String mName;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	@Override
	public String toString() {
		return "AlienName [fName=" + fName + ", lName=" + lName + ", mName=" + mName + "]";
	}

}
