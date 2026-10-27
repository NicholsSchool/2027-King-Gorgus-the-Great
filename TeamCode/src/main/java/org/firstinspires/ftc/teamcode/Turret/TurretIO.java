package org.firstinspires.ftc.teamcode.Turret;

public interface TurretIO {

    public static class TurretIOInputs{
        double turretPower = 0.0;
    }

    public default void updateInputs (TurretIO.TurretIOInputs inputs) {};
    public default void setTurretPower (double power) {};
}
