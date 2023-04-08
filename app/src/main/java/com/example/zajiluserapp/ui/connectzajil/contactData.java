package com.example.zajiluserapp.ui.connectzajil;

public class contactData {

    private String contactname, phone, companyname, email, address, city, country, subject, message, key;

    public contactData(){

    }
    public contactData(String contactname, String phone, String companyname,String email, String address, String city, String country, String subject, String message, String key){
      this.contactname = contactname;
      this.phone = phone;
      this.companyname = companyname;
      this.email = email;
      this.address = address;
      this.city = city;
      this.country=country;
      this.subject=subject;
      this.message=message;
      this.key=key;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}

