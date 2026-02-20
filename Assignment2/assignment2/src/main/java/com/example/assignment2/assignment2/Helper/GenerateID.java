package com.example.assignment2.assignment2.Helper;

import java.util.UUID;

public class GenerateID {
    public static long generateLongID (){

        return Math.abs(UUID.randomUUID().getLeastSignificantBits());
    }
}
