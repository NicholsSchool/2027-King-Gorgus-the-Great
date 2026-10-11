package org.firstinspires.ftc.teamcode.Drivetrain;

public interface DrivetrainIO {

    public static class DrivetrainIOInputs{
    }

    public default void updateInputs(DrivetrainIO.DrivetrainIOInputs inputs) {};
    public default void setDriveMotorPower(double y, double x, double turn) {};
    public default void setFieldDriveMotorPower(double y, double x, double turn, double headingOffset) {}

}
