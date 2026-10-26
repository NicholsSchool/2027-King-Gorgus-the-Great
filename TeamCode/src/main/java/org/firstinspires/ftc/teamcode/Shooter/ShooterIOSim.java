package org.firstinspires.ftc.teamcode.Shooter;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.SimStuff.MotorType;
import org.firstinspires.ftc.teamcode.SimStuff.SimMotor;
import org.firstinspires.ftc.teamcode.SimStuff.SimServo;

public class ShooterIOSim implements ShooterIO{

    public SimMotor nectarShooter, pollenShooter;
    public SimServo nectarStop, pollenStop;

    public ShooterIOSim(){
        nectarShooter = new SimMotor(MotorType.GOBILDA_6000);
        pollenShooter = new SimMotor(MotorType.GOBILDA_6000);


    }

    @Override
    public void updateInputs(ShooterIOInputs inputs){
        inputs.nectarVelocity = nectarShooter.getVelocity(AngleUnit.DEGREES);
    }

    /**
     * @param power the power to set the Nectar shooter to
     */
    @Override
    public void setNectarPower(double power){
        nectarShooter.setPower(power);
    }

    /**
     * @param power the power to set the Pollen shooter to
     */
    @Override
    public void setPollenPower(double power){
        nectarShooter.setPower(power);
    }

    /**
     * @param velocity the velocity to set the shooter to in Degrees/Second
     * RPM to D/S is RPM * 6
     */
    @Override
    public void setNectarVelocity(double velocity){
        nectarShooter.setVelocity(velocity, AngleUnit.DEGREES);
    }

    /**
     * @param velocity the velocity to set the shooter to in Degrees/Second
     * RPM to D/S is RPM * 6
     */
    @Override
    public void setPollenVelocity(double velocity){
        pollenShooter.setVelocity(velocity, AngleUnit.DEGREES);
    }
}
