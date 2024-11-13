package test;

import logics.RejextConcept;
import org.junit.Assert;
import org.junit.Test;

public class RejexConceptTest {

    RejextConcept rc = new RejextConcept();


    @Test
    public void validateNameTest() {

        boolean actual = rc.validateName("Vishal");
        boolean expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void validateCityTest() {
        boolean actual = rc.validateCity("Pune0122");
        boolean expected = true;
        Assert.assertEquals(expected,actual);

    }


}
