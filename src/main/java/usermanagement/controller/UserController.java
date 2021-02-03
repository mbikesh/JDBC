package usermanagement.controller;

import usermanagement.model.User;
import usermanagement.service.UserService;
import usermanagement.service.UserServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserController {
    public static void main(String[] args) {


        UserService userService = new UserServiceImpl();
        String decisions = null;
        do {
            String operation = JOptionPane.showInputDialog("Choose option: save/update/delete/list/get");
            switch (operation) {
                case "save":
                    User savedUser = getUser("save");
                    int saved = userService.saveUser(savedUser);
                    if (saved >= 1) {
                        JOptionPane.showMessageDialog(null, "Information saved");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");

                    }
                    break;
                case "update":
                    User updatedUser = getUser("update");
                    int updated = userService.updateUser(updatedUser);
                    if (updated >= 1) {
                        JOptionPane.showMessageDialog(null, "Information updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");

                    }
                    break;
                case "delete":
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    int deleted=userService.deleteUser(id);
                    if (deleted >= 1) {
                        JOptionPane.showMessageDialog(null, "Information deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");
                    }


                        break;
                case "list":
                    userService.getAllUser().forEach(user -> {
                        System.out.println("Id: "+user.getId());
                        System.out.println("Name: "+user.getUsername());
                        System.out.println("Password: "+user.getPassword());
                        System.out.println("Mobile Number: "+user.getMobileNo());
                        System.out.println("Is Enabled?: "+user.isEnable());
                        System.out.println("Salary: "+user.getSalary());
                        System.out.println("DOB: "+user.getDob());


                    });
                    break;
                case "get":
                     id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));

                    User user=userService.getUserById(id);
                    System.out.println("Id: "+user.getId());
                    System.out.println("Name: "+user.getUsername());
                    System.out.println("Password: "+user.getPassword());
                    System.out.println("Mobile Number: "+user.getMobileNo());
                    System.out.println("Is Enabled?: "+user.isEnable());
                    System.out.println("Salary: "+user.getSalary());
                    System.out.println("DOB: "+user.getDob());
                    System.out.println("======");
                    break;
            }
            decisions=JOptionPane.showInputDialog("Do you want to continue? yes/no");

        } while (decisions.equalsIgnoreCase("yes"));

    }
    public static User getUser(String type){
        User user=new User();
        if(type.equalsIgnoreCase("update")){
         int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id"));
          user.setId(id);
        }
        String username=JOptionPane.showInputDialog("Enter username");
        String password=JOptionPane.showInputDialog("Enter username");
        double salary=Double.parseDouble(JOptionPane.showInputDialog("Enter salary"));
        long mobileNo=Long.parseLong(JOptionPane.showInputDialog("Enter mobile number: "));
        boolean enable=Boolean.parseBoolean(JOptionPane.showInputDialog("is user enabled?"));
        String dob=JOptionPane.showInputDialog("Enter dob");
        LocalDate localDate=LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        user.setUsername(username);
        user.setPassword(password);
        user.setSalary(salary);
        user.setDob(localDate);
        user.setMobileNo(mobileNo);
        user.setEnable(enable);



        return user;
    }


}