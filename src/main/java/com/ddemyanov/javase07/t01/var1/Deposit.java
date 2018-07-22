package com.ddemyanov.javase07.t01.var1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
abstract class Deposit{

    final String id;
    long cash;
}