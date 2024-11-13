package test;

import logics.CutOffMarkCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CutOffMarkCalculatorTest {

    CutOffMarkCalculator cc = new CutOffMarkCalculator();

    @Test
    public void isEligibleByCasteTest() {
        Assert.assertEquals(true, cc.isEligibleByCaste(700, "FC"));
        Assert.assertEquals(true, cc.isEligibleByCaste(600, "BC"));
        Assert.assertEquals(true, cc.isEligibleByCaste(1000, "MBC"));
        Assert.assertEquals(true, cc.isEligibleByCaste(7100, "SC"));
        Assert.assertEquals(true, cc.isEligibleByCaste(7100, "ST"));
    }

    @Test
    public void isEligibleByCasteNegativeTest() {
        Assert.assertEquals(false, cc.isEligibleByCaste(100, "FC"));
        Assert.assertEquals(false, cc.isEligibleByCaste(60, "BC"));
        Assert.assertEquals(false, cc.isEligibleByCaste(100, "MBC"));
        Assert.assertEquals(false, cc.isEligibleByCaste(00, "SC"));
        Assert.assertEquals(false, cc.isEligibleByCaste(100, "ST"));
    }

}
