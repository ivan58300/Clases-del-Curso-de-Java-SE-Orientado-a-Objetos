public class Patient {

    static int id;
    private String name;
    private String email;
    private String adrees;
    private String phoneNumber;
    private String birthday;
    private String blood;
    private double weight;
    private double height;

    public Patient(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdrees() {
        return adrees;
    }

    public void setAdrees(String adrees) {
        this.adrees = adrees;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if ( phoneNumber.length() > 8 ){
            System.out.println("El número telefónico debe ser de 8 dígitos máximo. ");
        }else if(phoneNumber.length() == 8){
            this.phoneNumber = phoneNumber;
        }

    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getWeight() {
        return this.weight + "Kg.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return this.height + "Mts. ";
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
