package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AppTest {
    private static List<Person> list, list1, list2, list3, adultWomen, adultWomen1;

    @BeforeAll
    static void initializeLists() {
        list = List.of(new Person("Teodor", 16, Sex.MAN),
                new Person("Piter", 23, Sex.MAN),
                new Person("Olena", 42, Sex.WOMAN),
                new Person("Ivan Ivanovich", 69, Sex.MAN),
                new Person("Vasuluna", 17, Sex.WOMAN),
                new Person("Christine", 25, Sex.WOMAN),
                new Person("Nazar", 16, Sex.MAN),
                new Person("Oleg", 37, Sex.MAN),
                new Person("Gordon", 27, Sex.MAN));

        list1 = List.of(new Person("Teodor", 16, Sex.MAN),
                new Person("Piter", 23, Sex.MAN),
                new Person("Ivan Ivanovich", 69, Sex.MAN),
                new Person("Nazar", 16, Sex.MAN),
                new Person("Oleg", 37, Sex.MAN),
                new Person("Gordon", 27, Sex.MAN));

        list2 = new ArrayList<>();

        list3 = null;

        adultWomen = List.of(
                new Person("Olena", 42, Sex.WOMAN),
                new Person("Christine", 25, Sex.WOMAN));

        adultWomen1 = List.of(
                new Person("Olena", 42, Sex.WOMAN),
                new Person("Vasuluna", 17, Sex.WOMAN),
                new Person("Christine", 25, Sex.WOMAN));
    }

    @Test
    void testSelectAdultWomenWithSameList() {
        assertThat(App.selectAdultWomen(list)).isEqualTo(adultWomen);
        assertThat(App.selectAdultWomen(list)).containsAll(adultWomen);
    }

    @Test
    void testSelectAdultWomenWithNotSameList() {
        assertThat(App.selectAdultWomen(list)).isNotEqualTo(adultWomen1);
        assertThat(App.selectAdultWomen(list)).isNotEqualTo(list1);
    }

    @Test
    void shouldSelectAdultWomenReturnEmptyList() {
        assertThat(App.selectAdultWomen(list2)).isEmpty();
    }

    @Test
    void shouldSelectAdultWomenThrowExceptionOnNullList() {
        Throwable thrown = catchThrowable(() -> App.selectAdultWomen(list3));
        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldAverageMenAgeReturnTrueNumber() {
        assertThat(App.averageMenAge(list)).isEqualTo(31.0);
        assertThat(App.averageMenAge(list1)).isEqualTo(31.0);
    }

    @Test
    void testAverageMenAgeWithNoMenInList() {
        assertThat(App.averageMenAge(adultWomen)).isEqualTo(-1);
        assertThat(App.averageMenAge(adultWomen1)).isEqualTo(-1);
    }

    @Test
    void shouldAverageMenAgeReturnNegativeOnEmptyList() {
        assertThat(App.averageMenAge(list2)).isEqualTo(-1);
    }

    @Test
    void shouldAverageMenAgeThrowExceptionOnNullList() {
        Throwable thrown = catchThrowable(() -> App.averageMenAge(list3));
        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldCountAdultsReturnTrueNumber() {
        assertThat(App.countAdults(list)).isEqualTo(5);
        assertThat(App.countAdults(list1)).isEqualTo(3);
        assertThat(App.countAdults(adultWomen)).isEqualTo(2);
        assertThat(App.countAdults(adultWomen1)).isEqualTo(2);
        System.out.println(App.countAdults(list2));
    }

    @Test
    void shouldCountAdultsReturnZeroOnEmptyList() {
        assertThat(App.countAdults(list2)).isZero();
    }

    @Test
    void shouldCountAdultsThrowExceptionOnNullList() {
        Throwable thrown = catchThrowable(() -> App.countAdults(list3));
        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }
}
