package Priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import common.Patient;
import common.TreatmentType;

public class Priority {
	static String name;
	static int id;
	static TreatmentType treatmentTypeObj;
	static ArrayList<Patient> patientList = new ArrayList<Patient>();
	static Double averageWaitingTime = 0.0;
	static int sumWaitingTime = 0;
	static int waittingTimeForSum = 0;

	public static void main(String args[]) {
		Patient patientObj = new Patient();

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("***************************");
			System.out.print("Enter Your Name : ");
			name = sc.next();
			TreatmentType treatmentTypeObject = new TreatmentType();

			ArrayList<TreatmentType> treatmentType = new ArrayList<TreatmentType>();

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
			patientList.add(new Patient(name, treatmentTypeObj, 0,0));
			System.out.println("***************************");
			sortPiority();
		} while (!name.equals("000"));
	}

	public static void sortPiority() {

		Collections.sort(patientList, new Comparator<Patient>() {
			@Override
			public int compare(Patient p1, Patient p2) {
				return  (int) (p2.getTreatmentType().getTreatmentPriority() - p1.getTreatmentType().getTreatmentPriority());
			}
		});
		
		
		int turnAroundTime0;
		
		for (int i = 0; i < patientList.size(); i++) {
			if(i == 0) {
				patientList.get(i).setWaitTime(0);
			}else {
			turnAroundTime0 = patientList.get(i-1).getTreatmentType().getTreatmentTime()
					+ patientList.get(i-1).getWaitTime();
			patientList.get(i).setWaitTime(turnAroundTime0);
			}
		}
		sumWaitingTime = 0;
		patientList.forEach(patientListObjList -> {

			System.out.println(
					patientListObjList.getName() + "\t" + patientListObjList.getTreatmentType().getTreatmentName()
							+ "\t" + patientListObjList.getTreatmentType().getTreatmentTime() + "\t"
							+ patientListObjList.getWaitTime() + "\t");
			sumWaitingTime += patientListObjList.getWaitTime();
		});
		averageWaitingTime = (double) (sumWaitingTime / patientList.size());
		System.out.println(sumWaitingTime);
		System.out.println(averageWaitingTime);
	}

}
