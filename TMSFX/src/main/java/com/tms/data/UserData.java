package com.tms.data;

import com.tms.core.DbConnection;
import com.tms.core.Encryption;
import com.tms.enumurator.SortOrder;
import com.tms.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserData {

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_USER_NAME = "Username";
    public static final String COLUMN_PASSWORD_HASH = "PasswordHash";
    public static final String COLUMN_FULL_NAME = "FullName";
    public static final String COLUMN_PRIMARY_ADDRESS = "PrimaryAddress";
    public static final String COLUMN_PHONE_NUMBER = "PhoneNumber";
    public static final String COLUMN_START_DATE = "StartDate";
    public static final String COLUMN_SALARY_AMOUNT = "SalaryAmount";
    public static final String COLUMN_USER_TYPE = "UserType";

    private PreparedStatement statement;
    public static User currentLoginUser;

    public List<User> requestLogOn(String username, String password) {
        StringBuilder sb = new StringBuilder();
        sb.append(" Select * From " + TABLE_NAME);
        sb.append(" Where " + COLUMN_USER_NAME + " = ? ");
        sb.append(" And " + COLUMN_PASSWORD_HASH + " = ? ");

        try {

            statement = DbConnection.connection.prepareStatement(sb.toString());
            statement.setString(1, username);
            statement.setString(2, Encryption.MD5Hash(password));
            ResultSet results = statement.executeQuery();

            currentLoginUser = null;
            List<User> userList = new ArrayList<>();

            while (results.next()) {
                User user = new User();
                user.setId(results.getInt(COLUMN_ID));
                user.setUsername(results.getString(COLUMN_USER_NAME));
                user.setPasswordHash(results.getString(COLUMN_PASSWORD_HASH));
                user.setFullName(results.getString(COLUMN_FULL_NAME));
                user.setUsername(results.getString(COLUMN_USER_NAME));
                user.setPrimaryAddress(results.getString(COLUMN_PRIMARY_ADDRESS));
                user.setPhoneNumber(results.getString(COLUMN_PHONE_NUMBER));
                user.setStartDate(LocalDate.parse(results.getString(COLUMN_START_DATE)));
                user.setSalaryAmount(results.getDouble(COLUMN_SALARY_AMOUNT));
                user.setUserType(results.getString(COLUMN_USER_TYPE));
                userList.add(user);

                currentLoginUser = user;
            }

            return userList;

        } catch (SQLException e) {
            System.out.println("requestLogOn failed: " + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Close failed: " + e.getMessage());
            }
        }

    }

    public List<User> getAll() {
        StringBuilder sb = new StringBuilder("Select * From " + TABLE_NAME);
        sb.append(" Where " + COLUMN_USER_NAME + " = ? ");
        sb.append(" Order By " + COLUMN_USER_NAME + SortOrder.ORDER_BY_ASC);

        try {

            statement = DbConnection.connection.prepareStatement(sb.toString());
            statement.setString(1, "'admin");
            ResultSet results = statement.executeQuery();

            List<User> userList = new ArrayList<>();
            while (results.next()) {
                User user = new User();
                user.setId(results.getInt(COLUMN_ID));
                user.setUsername(results.getString(COLUMN_USER_NAME));
                user.setPasswordHash(results.getString(COLUMN_PASSWORD_HASH));
                user.setFullName(results.getString(COLUMN_FULL_NAME));
                user.setUsername(results.getString(COLUMN_USER_NAME));
                user.setPrimaryAddress(results.getString(COLUMN_PRIMARY_ADDRESS));
                user.setPhoneNumber(results.getString(COLUMN_PHONE_NUMBER));
                user.setStartDate(LocalDate.parse(results.getString(COLUMN_START_DATE)));
                user.setSalaryAmount(results.getDouble(COLUMN_SALARY_AMOUNT));
                user.setUserType(results.getString(COLUMN_USER_TYPE));
                userList.add(user);
            }

            return userList;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Close failed: " + e.getMessage());
            }
        }
    }


}
