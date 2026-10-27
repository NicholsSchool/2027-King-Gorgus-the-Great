package org.firstinspires.ftc.teamcode.FIntake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.Intake.IntakeIO;

public class FIntakeIOReal implements FIntakeIO{

    public Servo fIntake;
    public boolean fIntakeUp;

    public FIntakeIOReal(HardwareMap hwMap){

        fIntake = hwMap.get(Servo.class, "fIntake");

    }

    @Override
    public void updateInputs (FIntakeIO.FIntakeIOInputs inputs) {
        inputs.fIntakePos = fIntake.getPosition();
        fIntakeUp = inputs.fIntakePos > 0.7 && inputs.fIntakePos < 0.9;
        inputs.fIntakeUp = fIntakeUp;
    }

    @Override
    public void setPosition(double position){
        fIntake.setPosition(position);
    }
}
