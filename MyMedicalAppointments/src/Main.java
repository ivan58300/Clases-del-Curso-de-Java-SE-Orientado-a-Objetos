import java.util.Date;

import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {

        //showMenu();
        Doctor myDoctor = new Doctor("Ivanoe Lopez", "Dentista");
        myDoctor.addAvailableAppointments(new Date(), "4 pm");
        myDoctor.addAvailableAppointments(new Date(), "5 pm");
        myDoctor.addAvailableAppointments(new Date(), "6 pm");

        for (Doctor.AvailableAppointment a :myDoctor.getAvailableAppointments()) {
            System.out.println(a.getDate() + " " + a.getTime());
        }

    }
}
