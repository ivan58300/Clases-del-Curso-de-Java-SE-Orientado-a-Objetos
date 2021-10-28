package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.zip.Inflater;

public class UIPatientMenu {

    public static void showPatientMenu(){
        int response = 0;
        do {

            System.out.println("\n\n");
            System.out.println("\t- Patient -");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an Appointment");
            System.out.println("2. My appointments");
            System.out.println("0. logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyappointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;

            }
        }while (response != 0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println(":: Select date: ");
            //K = numeración de la lista de fechas
            //indice fecha seleccionada
            //[Doctors]
            /*
             * 1.- doctor1
             *           1.- fecha1
             *           2.- fecha2
             * 2.- doctor2
             * 3.- doctor3
             * */
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailablesAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailablesAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailablesAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);

                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println("Dr. " + doctorSelected.getName() +
                    ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime() +
                    "\n");

            System.out.println("Confirm your appointment: \n1. Yes\n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();

            }



        }while(response != 0);
    }

    private static void showPatientMyappointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if(UIMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Don´t have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "\nDate  : " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        "\nTime  : " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName() +
                        "\n");
            }

            System.out.println("0. Return ");
        }while(response != 0);
    }
}
