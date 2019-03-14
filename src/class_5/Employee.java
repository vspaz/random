package class_5;


public class Employee {
    private String initials;
    private String job;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String initials, String job, String email, String phone, double salary, int age) {
        this.initials = initials;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "%8s: %s\n%8s: %s\n%8s: %s\n%8s: %s\n%8s: %s\n%8s: %s",
                "initials", initials,
                "job",    job,
                "email",  email,
                "phone",  getPhone(),
                "salary", salary,
                "age",    age);
    }

    String getPhone() {
        return "8" + phone;
    }
    public int getAge() {
        return age;
    }
}
