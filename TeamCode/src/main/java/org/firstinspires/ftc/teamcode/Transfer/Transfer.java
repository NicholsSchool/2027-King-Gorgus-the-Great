package org.firstinspires.ftc.teamcode.Transfer;

import org.firstinspires.ftc.teamcode.Intake.IntakeIO;

public class Transfer implements TransferConstants{

    private final TransferIO io;
    private final TransferIO.TransferIOInputs inputs = new TransferIO.TransferIOInputs();
    public Transfer(TransferIO io){
        this.io = io;
    }

    public void feed(){
        io.setTransferPower(feedPower);
    }

    public void backfeed(){
        io.setTransferPower(backfeedPower);
    }

    /**
     * @return the current of the Transfer Motor in Amps
     */
    public double getTransferCurrent(){
        return inputs.transferCurrent;
    }
}
