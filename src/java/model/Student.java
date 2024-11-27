package model;

/**
 *
 * @author 12906
 */
public class Student {
    private int id;
    private String name;
    private String phone;
    private String registration_date;
    private String status;
    private int coach_id;
    private int session_one;
    private int session_two;
    private int session_three;
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public String getRegistration_date() {
        return this.registration_date;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public int getCoach_id() {
        return this.coach_id;
    }
    
    public int getSession_one() {
        return this.session_one;
    }
    
    public int getSession_two() {
        return this.session_two;
    }
    
    public int getSession_three() {
        return this.session_three;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }
    
    public void setSession_one(int session_one) {
        this.session_one = session_one;
    }
    
    public void setSession_two(int session_two) {
        this.session_two = session_two;
    }
    
    public void setSession_three(int session_three) {
        this.session_three = session_three;
    }
}