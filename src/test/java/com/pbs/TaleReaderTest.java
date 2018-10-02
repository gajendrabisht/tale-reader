package com.pbs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaleReaderTest {

    TaleReader taleReader = new TaleReader();

    @Test
    public void shouldReturnSingleOccurrences() {
        Map<String, Integer> report = taleReader.read(Arrays.asList("hello there").stream());
        assertThat(report.get("hello"), is(1));
        assertThat(report.get("there"), is(1));
    }

    @Test
    public void shouldReturnMultipleOccurrences() {
        Map<String, Integer> report = taleReader.read(Arrays.asList("hello here hello there hello everyone").stream());
        assertThat(report.get("hello"), is(3));
        assertThat(report.get("there"), is(1));
        assertThat(report.get("here"), is(1));
        assertThat(report.get("everyone"), is(1));
    }

}