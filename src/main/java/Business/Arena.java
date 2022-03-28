package Business;

import javax.persistence.*;

@Entity
@Table
public class Arena {

    @Id
    @Column(name = "arenaId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int arenaId;

    @Column(name = "arenaName")
    private String arenaName;

    @Column(name = "inside")
    private boolean inside;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address address;

    public Arena() {
    }

    public Arena(int arenaId, String arenaName, boolean inside) {
        this.arenaId = arenaId;
        this.arenaName = arenaName;
        this.inside = inside;
    }

    public String toStringAdv() {
        return "Arena{" +
                "arenaId=" + arenaId +
                "\n, arenaName='" + arenaName + "\n" +
                ", inside=" + inside +
                "\n, address=" + address +
                '}';
    }

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public String isInside() {
        if(inside==true)
            return "true";
                    else return "false";
    }

    public Boolean getInside(){
        return inside;
    }

    public void setInside(boolean inside) {
        this.inside = inside;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return arenaName+" - "+address;
    }
}
