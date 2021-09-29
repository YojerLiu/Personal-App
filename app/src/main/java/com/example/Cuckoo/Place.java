package com.example.Cuckoo;

public class Place {

    String district;
    String mailNumber;
    String Country;
    String language;
    PersonalResume PR;

    public Place() {
    }

    public Place(String district, String mailNumber, String country, String language, PersonalResume PR) {
        this.district = district;
        this.mailNumber = mailNumber;
        this.Country = country;
        this.language = language;
        this.PR = PR;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMailNumber() {
        return mailNumber;
    }

    public void setMailNumber(String mailNumber) {
        this.mailNumber = mailNumber;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public PersonalResume getPR(){
        return this.PR;
    }

    public void setPR(PersonalResume PR){
        this.PR = PR;
    }
}
