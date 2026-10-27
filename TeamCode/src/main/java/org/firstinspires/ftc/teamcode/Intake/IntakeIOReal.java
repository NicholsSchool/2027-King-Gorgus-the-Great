package org.firstinspires.ftc.teamcode.Intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DigitalChannelImpl;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class IntakeIOReal implements IntakeIO{

    //GoBilda ____RPM motor
    public DcMotorEx intake;

    //Gobilda distance sensor, swyft distance sensor Left, swyft distance sensor Right
    public DigitalChannel gBDistance, sDistanceLeft, sDistanceRight;

    public IntakeIOReal(HardwareMap hwMap){

        intake = hwMap.get(DcMotorEx.class, "intake");
        gBDistance = hwMap.get(DigitalChannel.class, "gBDistance");
        sDistanceLeft = hwMap.get(DigitalChannel.class, "sDistanceLeft");
        sDistanceRight = hwMap.get(DigitalChannel.class, "sDistanceRight");

        gBDistance.setMode(DigitalChannel.Mode.INPUT);
        sDistanceLeft.setMode(DigitalChannel.Mode.INPUT);
        sDistanceRight.setMode(DigitalChannel.Mode.INPUT);

    }

    @Override
    public void updateInputs (IntakeIO.IntakeIOInputs inputs) {
        inputs.intakeCurrent = intake.getCurrent(CurrentUnit.AMPS);
        inputs.intakePower = intake.getPower();
        inputs.leftDistance = sDistanceLeft.getState();
        inputs.middleDistance = gBDistance.getState();
        inputs.rightDistance = sDistanceRight.getState();
        inputs.overallVerdict = (inputs.leftDistance && inputs.middleDistance) || (inputs.leftDistance && inputs.rightDistance) || (inputs.middleDistance && inputs.rightDistance);
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
