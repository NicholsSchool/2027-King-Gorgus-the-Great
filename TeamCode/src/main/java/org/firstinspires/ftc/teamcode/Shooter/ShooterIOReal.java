package org.firstinspires.ftc.teamcode.Shooter;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class ShooterIOReal implements ShooterIO, ShooterConstants{

    public DcMotorEx nectarShooter, pollenShooter;
    public Servo nectarStop, pollenStop;

    public ShooterIOReal(HardwareMap hwMap){

        nectarShooter = hwMap.get(DcMotorEx.class, "nectar");
        pollenShooter = hwMap.get(DcMotorEx.class, "pollen");

        nectarStop = hwMap.get(Servo.class, "nectarStop");
        pollenStop = hwMap.get(Servo.class, "pollenStop");

        nectarShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        pollenShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        nectarShooter.setVelocityPIDFCoefficients(kNP,kNI,kND,kNF);
        pollenShooter.setVelocityPIDFCoefficients(kPP,kPI,kPD,kPF);

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
