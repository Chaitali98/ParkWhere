package com.example.parkwhere;

import android.os.Parcel;
import android.os.Parcelable;

class User implements Parcelable {
    int id;
    String Firstname;
    String Lastname;
    String ContactDetails;

    public User(){}
    public User(String Fname , String Lname) {
        Firstname = Fname;
        Lastname = Lname;
    }

    private User(Parcel in)
    {
        Firstname = in.readString();
        Lastname = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR;

    static {
        CREATOR = new Creator<User>() {
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            public User[] newArray(int size) {
                return new User[size];
            }
        };
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getid()
    {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(Firstname);
            parcel.writeString(Lastname);
    }
}
