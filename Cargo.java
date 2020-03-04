/**
 * @author OGUZHAN SENTURK
 */
public class Cargo {

    private Customer sender_info;
    private Customer receiver_info;
    private String track_num;
    private String cargo_status;
    /**
     * Constructor of Cargo Class
     * @param sender_info This is sender customer
     * @param receiver_info This is receiver customer
     * @param track_num This is Cargo tracking number
     * @param cargo_status This is cargo status
     */
    public Cargo(Customer sender_info, Customer receiver_info, String track_num, String cargo_status) {
        this.sender_info = sender_info;
        this.receiver_info = receiver_info;
        this.track_num = track_num;
        this.cargo_status = cargo_status;
    }
    /**
     * @return the sender_info
     */
    public Customer getSender_info() {
        return sender_info;
    }
    /**
     * @param sender_info the sender_info to set
     */
    public void setSender_info(Customer sender_info) {
        this.sender_info = sender_info;
    }
    /**
     * @return the receiver_info
     */
    public Customer getReceiver_info() {
        return receiver_info;
    }
    /**
     * @param receiver_info the receiver_info to set
     */
    public void setReceiver_info(Customer receiver_info) {
        this.receiver_info = receiver_info;
    }
    /**
     * @return the track_num
     */
    public String getTrack_num() {
        return track_num;
    }
    /**
     * @param track_num the track_num to set
     */
    public void setTrack_num(String track_num) {
        this.track_num = track_num;
    }
    /**
     * @return the cargo_status
     */
    public String getCargo_status() {
        return cargo_status;
    }
    /**
     * @param cargo_status the cargo_status to set
     */
    public void setCargo_status(String cargo_status) {
        this.cargo_status = cargo_status;
    }

}
