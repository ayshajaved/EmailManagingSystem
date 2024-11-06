public class Address {
    private String city;
    private String country;
    private int postalCode;
    Address(String city, String country, int code){
        if(city == null || city.trim().isEmpty() || country == null || country.trim().isEmpty() || code < 0){//checking if the address are valid or not
            throw new IllegalArgumentException("Invalid address");
        }
        this.city = city;
        this.country = country;
        this.postalCode = code;
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
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", country=" + country + ", postalCode=" + postalCode + '}';
    }
}
