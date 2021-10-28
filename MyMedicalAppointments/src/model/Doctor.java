package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributos
    private String speciality;

    public Doctor(String name, String email){
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointments (String date,String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return  availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSpeciality: " + speciality  +
                "\nAvailable: " + availableAppointments.toString() ;
    }

    @Override
    public void showDateUser() {
        System.out.println("Empleado de Hospital: Cruz Roja.");
        System.out.println("Departamento: Cancerología.");
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        /*
        * vamos a usar esta clase para formatear fechas y poder trabajar con fechas
        * vamos a usar el método parse(String); que convierte el String en Date.
        * */
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {//el parametro es para saber que este metodo me va a devolver un Date
            return date;
        }
        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointment" +
                    "\ndate: " + date +
                    "\ntime: " + time;
        }
    }

}