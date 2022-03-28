package Business;

import javax.persistence.*;

@Entity
@Table(name = "cusadd")
public class CusAdd {

    @Id
    @Column(name = "cusAddId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cusAddId;

    @Column(name = "customerId")
    private int customerId;

    @Column(name = "addressId")
    private int addressId;

    public CusAdd() {
    }

    public CusAdd(int cusAddId, int customerId, int addressId) {
        this.cusAddId = cusAddId;
        this.customerId = customerId;
        this.addressId = addressId;
    }

    public int getCusAddId() {
        return cusAddId;
    }

    public void setCusAddId(int cusAddId) {
        this.cusAddId = cusAddId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "CusAdd{" +
                "cusAddId=" + cusAddId +
                ", customerId=" + customerId +
                ", addressId=" + addressId +
                '}';
    }
}
