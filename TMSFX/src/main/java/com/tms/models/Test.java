package com.tms.models;

import com.tms.data.UserData;

import java.util.List;

public class Test {

    public static void main(String[] args) {
//        User user = new User();
//
//        user.setStartDate(LocalDate.of(2021, 12, 1));
//        System.out.println(user.getStartDate().getYear());
//        System.out.println(user.getStartDate().getMonthValue());
//        System.out.println(user.getStartDate().getDayOfMonth());

//        UserType u = new UserType("Admin");
//        System.out.println(u.toString());
//        System.out.println(u.getValue());
//
//        System.out.println("ss: " + new UserType("").getValue());
//
//
//        LocalDate l = LocalDate.parse("2021-12-01");
//
//        System.out.println(l.getYear());
//        System.out.println(l.getMonthValue());
//        System.out.println(l.getDayOfMonth());

        //List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        UserData userData = new UserData();

        List<User> userList = userData.getAll();
        if (!userList.isEmpty()) {
            for (User data : userList) {
                System.out.println("Id____: " + data.getId());
                System.out.println("Name: " + data.getUsername());
            }
        } else {
            System.out.println("No data to display.");
        }



    }
}
