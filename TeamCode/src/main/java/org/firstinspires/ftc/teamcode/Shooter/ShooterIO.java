package org.firstinspires.ftc.teamcode.Shooter;

public interface ShooterIO {

    public static class ShooterIOInputs {
        double nectarVelocity = 0.0;
    }

    public default void updateInputs(ShooterIO.ShooterIOInputs inputs) {};

    /**
     * @param power the power to set the Nectar shooter to
     */
    public default void setNectarPower (double power) {};

    /**
     * @param power the power to set the Pollen shooter to
     */
    public default void setPollenPower (double power) {};

    /**
     * @param velocity the velocity to set the shooter to in Degrees/Second
     * RPM to D/S is RPM * 6
     */
    public default void setNectarVelocity (double velocity) {};

    /**
     * @param velocity the velocity to set the shooter to in Degrees/Second
     * RPM to D/S is RPM * 6
     */
    public default void setPollenVelocity(double velocity) {};

}
