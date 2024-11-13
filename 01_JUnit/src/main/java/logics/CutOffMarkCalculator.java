package logics;

public class CutOffMarkCalculator {

    public void isValidMarks(int cutOffMarks) {
        if (cutOffMarks < 0) {
            throw new IllegalArgumentException("Given cutOffMarks should be positive!");
        }
    }

    public boolean isEligibleByCaste(int cutOffMarks, String caste) {
        isValidMarks(cutOffMarks);


        if (caste != null && caste.equalsIgnoreCase("FC") && cutOffMarks >= 600) {
            return true;
        } else if (caste != null && caste.equalsIgnoreCase("BC") && cutOffMarks >= 580) {
            return true;
        } else if (caste != null && caste.equalsIgnoreCase("MBC") && cutOffMarks >= 550) {
            return true;
        } else if (caste != null && caste.equalsIgnoreCase("SC") && cutOffMarks >= 400) {
            return true;
        } else if (caste != null && caste.equalsIgnoreCase("ST") && cutOffMarks >= 350) {
            return true;
        } else {
            return false;
        }

    }
}
