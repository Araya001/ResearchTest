package common;

import java.util.ArrayList;

public class Factor {
	int factorId;
	String factorName;
	double factorTrue;
	double factorFalse;

	public int getFactorId() {
		return factorId;
	}

	public void setFactorId(int factorId) {
		this.factorId = factorId;
	}

	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public double getFactorTrue() {
		return factorTrue;
	}

	public void setFactorTrue(double factorTrue) {
		this.factorTrue = factorTrue;
	}

	public double getFactorFalse() {
		return factorFalse;
	}

	public void setFactorFalse(double factorFalse) {
		this.factorFalse = factorFalse;
	}

	public Factor(int factorId, String factorName, double factorTrue, double factorFalse) {
		super();
		this.factorId = factorId;
		this.factorName = factorName;
		this.factorTrue = factorTrue;
		this.factorFalse = factorFalse;
	}

	public Factor() {
		super();
	}

	public ArrayList<Factor> setFactorType() {
		ArrayList<Factor> factorType = new ArrayList<Factor>();
		factorType.add(new Factor(1, "เป็นสมาชิก", 0.5, 0.25));
		factorType.add(new Factor(2, "นัดหมาย", 0.75, 0.5));
		factorType.add(new Factor(3, "บ้านไกล", 0.3, 0.25));
		factorType.add(new Factor(4, "มีภาระ", 0.3, 0.25));
		factorType.add(new Factor(5, "คนท้อง", 0.5, 0.4));
		factorType.add(new Factor(6, "จำนวนสัตว์เลี้ยงมากกว่า 1 ตัว", 0.25, 0.2));
		return factorType;

	}

}
