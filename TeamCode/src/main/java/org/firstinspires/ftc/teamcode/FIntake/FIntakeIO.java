package org.firstinspires.ftc.teamcode.FIntake;

import org.firstinspires.ftc.teamcode.Intake.IntakeIO;

public interface FIntakeIO {

    public static class FIntakeIOInputs{
        double fIntakePos = 0.0;
        boolean fIntakeUp = true;
    }

    public default void updateInputs (FIntakeIO.FIntakeIOInputs inputs) {};
    public default void setPosition (double position) {};
}
