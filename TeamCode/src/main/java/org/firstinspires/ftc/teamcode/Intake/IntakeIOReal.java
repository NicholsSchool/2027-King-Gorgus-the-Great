package org.firstinspires.ftc.teamcode.Intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class IntakeIOReal implements IntakeIO{

    public DcMotorEx intake;

    public IntakeIOReal(HardwareMap hwMap){

        intake = hwMap.get(DcMotorEx.class, "intake");

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
