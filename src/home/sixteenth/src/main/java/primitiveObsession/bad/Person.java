package home.sixteenth.src.main.java.primitiveObsession.bad;

public class Person {
    private String name;
    private String mobileCode;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneNumber(){
        return ("+7("+getMobileCode()+")"+ getNumber());
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setMobileCode("900");
        person.setNumber("1357686");
        System.out.println(person.getPhoneNumber());
    }
}
