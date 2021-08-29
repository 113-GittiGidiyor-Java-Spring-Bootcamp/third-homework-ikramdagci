package com.ikramdagci.thirdhomework.model.enumeration;

public enum Gender {

    FEMALE('F'),MALE('M');

    private Character gender;

    Gender(Character gender) {
        this.gender = gender;
    }

    public Character getGender() {
        return gender;
    }

}
