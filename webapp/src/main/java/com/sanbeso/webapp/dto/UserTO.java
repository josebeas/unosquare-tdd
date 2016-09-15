package com.sanbeso.webapp.dto;

import java.io.Serializable;

/**
 * User transfer object
 *
 * @author Jose Beas
 * @version 1.0
 */
public class UserTO implements Serializable{

    public UserTO(){
        this.firstName = "Public";
        this.lastName = "User";
        this.isPublic =  true;
    }

    /**
     * String with username
     */
    private String userName;

    /**
     * String with user password
     */
    private String firstName;

    /**
     * String used to store last name for user
     */
    private String lastName;

    /**
     * Determines if user belongs to system or not
     */
    private boolean isPublic;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
