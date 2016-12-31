/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin-pc
 */
public class Admin {
    private int Id;
    private String username;
    private String password;
    private String address;

    public Admin() {
    }

    public Admin(int Id, String username, String password, String address) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
