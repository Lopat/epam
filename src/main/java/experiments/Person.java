package experiments;

import lombok.*;

import java.util.GregorianCalendar;

@Data
@Getter
@Setter
@ToString(includeFieldNames = false, exclude = "birthday", doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
class Person {

    private static int count;
    private String name;
    private String surName;
    private Sex sex;

    private GregorianCalendar birthday;
    private Profession profession;

    enum Sex {
        MAN, WOMAN
    }

    enum Profession {
        DOCTOR, COP, FIREMAN, TEACHER, PROGRAMMER
    }
}
