package common;
import common.TreatmentType;

public class Patient {
	String name;
	TreatmentType treatmentType;
	int waitTime;
	double patientPriority;
	
	public double getPatientPriority() {
		return patientPriority;
	}
	public void setPatientPriority(double patientPriority) {
		this.patientPriority = patientPriority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TreatmentType getTreatmentType() {
		return treatmentType;
	}
	public void setTreatmentType(TreatmentType treatmentType) {
		this.treatmentType = treatmentType;
	}
	public int getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	public Patient(String name, TreatmentType treatmentType, int waitTime, double patientPriority) {
		super();
		this.name = name;
		this.treatmentType = treatmentType;
		this.waitTime = waitTime;
		this.patientPriority = patientPriority;
	}
	public Patient() {
		super();
	}
	
	
}
