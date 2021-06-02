package case_study_FuramaResort.models;

public class MovieTicket {
    private String idTicket;
    private String customerName;
    private int seat;

    public MovieTicket() {
    }

    public MovieTicket(String idTicket, String customerName, int seat) {
        this.idTicket = idTicket;
        this.customerName = customerName;
        this.seat = seat;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "MovieTicket{" +
                "idTicket='" + idTicket + '\'' +
                ", customerName='" + customerName + '\'' +
                ", seat=" + seat +
                '}';
    }
}
