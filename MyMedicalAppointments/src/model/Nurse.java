package model;

public class Nurse extends User {

    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDateUser() {
        System.out.println("Empleado de Hospital: Cruz Verde.");
        System.out.println("Departamento: Nutriología, Pediatría");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
