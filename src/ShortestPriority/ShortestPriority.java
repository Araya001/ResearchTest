package ShortestPriority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import common.Factor;
import common.Patient;
import common.TreatmentType;

public class ShortestPriority {
	static String name;
	static int id;
	static String factorBoolean;
	static TreatmentType treatmentTypeObj;
	static ArrayList<Patient> patientList = new ArrayList<Patient>();
	static ArrayList<Factor> factorList = new ArrayList<Factor>();
	static Double averageWaitingTime = 0.0;
	static int sumWaitingTime = 0;
	static int waittingTimeForSum = 0;
	static double patientPrioritySum = 1;

	public static void main(String[] args) {
		Patient patientObj = new Patient();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("***************************");
			System.out.print("Enter Your Name : ");
			name = sc.next();
			TreatmentType treatmentTypeObject = new TreatmentType();
			ArrayList<TreatmentType> treatmentType = new ArrayList<TreatmentType>();

			Factor factor = new Factor();

			treatmentType = treatmentTypeObject.setTreatmentType();
			System.out.println("***************************");
			treatmentType.forEach(treatmentTypeObj -> {
				System.out.println(treatmentTypeObj.getTreatmentId() + "\t" + treatmentTypeObj.getTreatmentName() + "\t"
						+ treatmentTypeObj.getTreatmentPriority() + "\t" + treatmentTypeObj.getTreatmentTime());
			});
			System.out.println("***************************");
			System.out.print("Enter Your Treatment Type : ");

			id = sc.nextInt();
			treatmentType.forEach(treatmentTypeObjList -> {
				if (treatmentTypeObjList.getTreatmentId() == id) {
					treatmentTypeObj = treatmentTypeObjList;
				}
			});

			System.out.println("***************************");
			patientPrioritySum = 1;
			factorList = factor.setFactorType();
			factorList.forEach(factorListObj -> {
				System.out.println(factorListObj.getFactorId() + "\t" + factorListObj.getFactorName() + "\t"
						+ factorListObj.getFactorTrue() + "\t" + factorListObj.getFactorFalse());
				factorBoolean = sc.next();
				if (factorBoolean.equals("t") || factorBoolean.equals("T")) {
					patientPrioritySum *= factorListObj.getFactorTrue();
					//System.out.println(factorListObj.getFactorTrue());
				} else if (factorBoolean.equals("f") || factorBoolean.equals("F")) {
					patientPrioritySum *= factorListObj.getFactorFalse();
					//System.out.println(factorListObj.getFactorFalse());
				}

			});

			patientList.add(new Patient(name, treatmentTypeObj, 0,
					patientPrioritySum * treatmentTypeObj.getTreatmentPriority()));

			sortPiority();
		} while (!name.equals("000"));
	}

	public static void sortPiority() {

		Collections.sort(patientList, new Comparator<Patient>() {
			@Override
			public int compare(Patient p1, Patient p2) {
				return (int) (p2.getPatientPriority()*1000 - p1.getPatientPriority()*1000);
			}
		});

		int turnAroundTime0;

		for (int i = 0; i < patientList.size(); i++) {
			if (i == 0) {
				patientList.get(i).setWaitTime(0);
			} else {
				turnAroundTime0 = patientList.get(i - 1).getTreatmentType().getTreatmentTime()
						+ patientList.get(i - 1).getWaitTime();
				patientList.get(i).setWaitTime(turnAroundTime0);
			}
		}
		sumWaitingTime = 0;
		patientList.forEach(patientListObjList -> {
			System.out.println("ลำดับ \tการรักษา\tTime\tWait Time\tPriority");
			System.out.println(
					patientListObjList.getName() + "\t" + patientListObjList.getTreatmentType().getTreatmentName()
							+ "\t" + patientListObjList.getTreatmentType().getTreatmentTime() + "\t"
							+ patientListObjList.getWaitTime() + "\t\t" + patientListObjList.getPatientPriority());
			sumWaitingTime += patientListObjList.getWaitTime();
		});
		averageWaitingTime = (double) (sumWaitingTime / patientList.size());
		System.out.println(sumWaitingTime);
		System.out.println(averageWaitingTime);
	}

}
