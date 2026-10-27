package org.firstinspires.ftc.teamcode.FIntake;


public class FIntake implements FIntakeConstants {

    private final FIntakeIO io;
    private final FIntakeIO.FIntakeIOInputs inputs = new FIntakeIO.FIntakeIOInputs();
    public FIntake(FIntakeIO io) { this.io = io;}

    public void periodic(){}

    public void fIntakeUp(){
        io.setPosition(fIntakeUpPos);
    }

    public void fIntakeDown(){
        io.setPosition(fIntakeDownPos);
    }
}
