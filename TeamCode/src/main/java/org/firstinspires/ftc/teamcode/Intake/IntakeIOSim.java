package org.firstinspires.ftc.teamcode.Intake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.SimStuff.MotorType;
import org.firstinspires.ftc.teamcode.SimStuff.SimMotor;

public class IntakeIOSim implements IntakeIO{
    public SimMotor intake;

    public IntakeIOSim(HardwareMap hwMap){

        intake = new SimMotor(MotorType.GOBILDA_1150);

    }

    @Override
    public void updateInputs (IntakeIO.IntakeIOInputs inputs) {
        inputs.intakeCurrent = intake.getCurrent(CurrentUnit.AMPS);
        inputs.intakePower = intake.getPower();
    }

    /**
     * provides the given power to the intake motor
     * @param power the power supplied to the intake motor
     * */

    @Override
    public void setIntakePower(double power){
        intake.setPower(power);
    }

}

