package org.firstinspires.ftc.teamcode.Transfer;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.Intake.IntakeIO;

public class TransferIOReal implements TransferIO{

    public DcMotorEx transfer;

    public TransferIOReal(HardwareMap hwMap){
        transfer = hwMap.get(DcMotorEx.class, "transfer");
    }

    @Override
    public void updateInputs (TransferIO.TransferIOInputs inputs) {
        inputs.transferCurrent = transfer.getCurrent(CurrentUnit.AMPS);
    }


    /**
     * @param power the power given to the transfer motor
     */
    @Override
    public void setTransferPower(double power){
        transfer.setPower(power);
    }

}
