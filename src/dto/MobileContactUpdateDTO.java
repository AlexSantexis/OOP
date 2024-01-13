package dto;

public class MobileContactUpdateDTO extends BaseDTO {
    private UserDetailsUpdateDTO userDetailsUpdateDTO;
    private String phoneNumber;

    public MobileContactUpdateDTO() {
    }

    public UserDetailsUpdateDTO getUserDetailsUpdateDTO() {
        return userDetailsUpdateDTO;
    }

    public void setUserDetailsUpdateDTO(UserDetailsUpdateDTO userDetailsUpdateDTO) {
        this.userDetailsUpdateDTO = userDetailsUpdateDTO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
