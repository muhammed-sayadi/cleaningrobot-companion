package com.cleaningrobot.model.builder;

import com.cleaningrobot.model.User;

public class UserBuilder
{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long phone;

    public UserBuilder()
    {

    }

    public UserBuilder(int id, String firstName, String lastName, String email, String password, long phone)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public long getPhone()
    {
        return phone;
    }

    public UserBuilder withId(int id)
    {
        this.id = id;
        return this;
    }

    public UserBuilder withFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withEmail(String email)
    {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password)
    {
        this.password = password;
        return this;
    }

    public UserBuilder withPhone(long phone)
    {
        this.phone = phone;
        return this;
    }

    public User build()
    {
        return new User(this);
    }
}
