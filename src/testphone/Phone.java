package testphone;

public class Phone {
    private  String phoneId, phoneName,Supllier;
    private  int price;

    public String getPhoneId() {
        return phoneId;
    }

    public Phone() {
        phoneId =null;
        phoneName = null;
        Supllier = null;
        price=0;
    }

    public Phone(String phoneId, String phoneName, String Supllier, int price) {
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.Supllier = Supllier;
        this.price = price;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getSupllier() {
        return Supllier;
    }

    public void setSupllier(String Supllier) {
        this.Supllier = Supllier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone[" + "phoneId=" + phoneId + ", phoneName=" + phoneName + ", Supllier=" + Supllier + ", price=" + price + ']';
    }
    
}
