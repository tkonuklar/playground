package com.example.domain;

import org.immutables.value.Value;

@Value.Immutable
public class User {
    private String name;
    private String surname;
    private int id;
}
