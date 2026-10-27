package org.firstinspires.ftc.teamcode.Shooter;

public class Shooter implements ShooterConstants, ShooterIO {

    private final ShooterIO io;
    private final ShooterIO.ShooterIOInputs inputs = new ShooterIO.ShooterIOInputs();

    public Shooter(ShooterIO io) {this.io = io;}

    public void periodic(){}

    public void revShooterWheelsPower(){
        io.setNectarPower(nectarConstantPower);
        io.setPollenPower(pollenConstantPower);
    }

    public void revShooterWheelsVelocity(){
        io.setNectarVelocity(nectarConstantVelocity);
        io.setPollenVelocity(pollenConstantVelocity);
    }

    public void turnOffShooters(){
        io.setNectarVelocity(0.0);
        io.setPollenVelocity(0.0);
    }

}
