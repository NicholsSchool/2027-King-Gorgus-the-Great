package org.firstinspires.ftc.teamcode.Shooter;

public class Shooter implements ShooterConstants, ShooterIO {

    private final ShooterIO io;
    private final ShooterIO.ShooterIOInputs inputs = new ShooterIO.ShooterIOInputs();

    public Shooter(ShooterIO io) {this.io = io;}

    public void revShooterWheelsPower(){ //TODO: Edit the Power Values
        io.setNectarPower(1.0);
        io.setPollenPower(1.0);
    }

    public void revShooterWheelsVelocity(){ //TODO: Edit the Velocity Values
        io.setNectarVelocity(100.0);
        io.setPollenVelocity(100.0);
    }

}
