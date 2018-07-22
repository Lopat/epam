package com.ddemyanov.javase07.t01.var2;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class Deposit {

    final int id;

}
