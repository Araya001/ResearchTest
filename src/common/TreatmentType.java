package common;

import java.util.ArrayList;

public class TreatmentType {
	int treatmentId;
	String treatmentName;
	int treatmentTime;
	double treatmentPriority;

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public int getTreatmentTime() {
		return treatmentTime;
	}

	public void setTreatmentTime(int treatmentTime) {
		this.treatmentTime = treatmentTime;
	}

	public double getTreatmentPriority() {
		return treatmentPriority;
	}

	public void setTreatmentPriority(double treatmentPriority) {
		this.treatmentPriority = treatmentPriority;
	}

	public TreatmentType() {
		super();
	}

	public TreatmentType(int treatmentId, String treatmentName, int treatmentTime, double treatmentPriority) {
		super();
		this.treatmentId = treatmentId;
		this.treatmentName = treatmentName;
		this.treatmentTime = treatmentTime;
		this.treatmentPriority = treatmentPriority;
	}

	public ArrayList<TreatmentType> setTreatmentType() {
		ArrayList<TreatmentType> treatmentType = new ArrayList<TreatmentType>();
		treatmentType.add(new TreatmentType(1, "รักษาตื้น", 30, 1));
		treatmentType.add(new TreatmentType(2, "รักษาลึก", 45, 1));
		treatmentType.add(new TreatmentType(3, "วัคซีน", 10, 3));
		treatmentType.add(new TreatmentType(4, "ฉุกเฉิน 1", 60, 4));
		treatmentType.add(new TreatmentType(5, "ฉุกเฉิน 2", 60, 5));
		treatmentType.add(new TreatmentType(6, "ฉุกเฉิน 3", 60, 6));
		return treatmentType;

	}

}
