package org.firstinspires.ftc.teamcode.Intake;

public interface IntakeIO {

    public static class IntakeIOInputs{

        double intakeCurrent = 0.0;
        double intakePower = 0.0;
        boolean leftDistance = false;
        boolean middleDistance = false;
        boolean rightDistance = false;
        boolean overallVerdict = false;

    }

    public default void updateInputs (IntakeIO.IntakeIOInputs inputs) {};
    public default void setIntakePower(double power){};

}
