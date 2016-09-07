package home.sixteenth.src.main.java.primitiveObsession.good;

public class Person {
    private String name;
    private PhoneNumber phoneNumber = new PhoneNumber();

    public String getName() {
        return name;
    }

    public PhoneNumber getOfficeTelephone() {
        return phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber.getPhoneNumber();
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.getOfficeTelephone().setMobileCode("900");
        person.getOfficeTelephone().setNumber("1357686");
        System.out.println(person.getPhoneNumber());
    }
}

class PhoneNumber {
    private String code;
    private String number;

    public void setMobileCode(String code) {
        this.code = code;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneNumber(){
        return ("+7("+code+")"+ number);
    }
}
