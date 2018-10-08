package learn;

public class Customer {
    /**
     * We declare variable
     */
    String firstName;
    String lastname;
    String adress;
    int age;

    /**
     * We create a method
     * @return
     */

    public String getInfo()
    {
        return ("First name is:"+firstName+" Last name is "+lastname+" Adress is "+adress+" Age is"+age );
    }

    public static void main (String [] args) {
        Customer customer = new Customer();
        customer.adress = "Cluj-Napoca";
        customer.firstName = "Ruben";
        customer.lastname = "Pintican";
        customer.age = 23;
        System.out.println(customer.getInfo());
}}

