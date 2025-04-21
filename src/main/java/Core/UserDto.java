package Core;
/**
 * Project Name: User
 * File Name: DAVIS_Selenium_IWeek2_Buffer.java
 * Author: David Davis
 * Date: April 16, 2025
 * So I created this to uses as a dto. the reason why it's not a record and or
 *  has getters and setters is that I tried out the refactor to getters and setters.
 */

public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address1;
    private String city;
    private String state;
    private String postalcode;
    private String country; 
    private String username;
    private String password;

    public UserDto(){}
    
    public UserDto(int id,
    String FirstName,
    String LastName,
    String Phone,
    String Email,
    String Address1,
    String City,
    String State,
    String Postalcode,
    String Country, 
    String UserName,
    String Password){
        this.id = id;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.phone = Phone;
        this.email = Email;
        this.address1 = Address1;
        this.city = City;
        this.state = State;
        this.postalcode = Postalcode;
        this.country =  Country;
        this.username = UserName;
        this.password = Password;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress1() {
        return address1;
    }
    
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getPostalcode() {
        return postalcode;
    }
    
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    } 
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    } 
}