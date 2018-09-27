package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void returnsNameWhenAsked() {
        assertThat(queryProcessor.process("what is your name"), containsString("TDD Cow"));
    }

    @Test
    public void addsTwoNumbers() {
        assertThat(queryProcessor.process("what is 20 plus 10"), containsString("30"));
        assertThat(queryProcessor.process("what is 25 plus 15"), containsString("40"));
        assertThat(queryProcessor.process("what is 2 plus 1"), containsString("3"));

    }

    @Test
    public void findsLargestNumber() {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 23, 53, 65, 7"), containsString("65"));
        assertThat(queryProcessor.process("which of the following numbers is the largest: 100, 53, 65, 7"), containsString("100"));


    }
}
