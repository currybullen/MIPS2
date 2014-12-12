package controller;

import model.*;

/**
 * Created by currybullen on 2014-12-11.
 */
public class Simulator {
    private InstructionMemory instructionMemory;
    private Registers registers;
    private DataMemory dataMemory;
    private PC pc;

    public Simulator(InstructionMemory instructionMemory, Registers registers,
                     DataMemory dataMemory) {
        this.instructionMemory = instructionMemory;
        this.registers = registers;
        this.dataMemory = dataMemory;
        pc = new PC();
    }


    public int step() {
        Add pcAdd = new Add();
        Add branchAdd = new Add();

        Instruction inst = null;
        Multiplexer pcMultiplex = new Multiplexer();

        ControlLines controlLines = new ControlLines();
        Control controlUnit = new Control(controlLines);

        //Multiplex for register write input
        Multiplexer regMult = new Multiplexer();

        //For ALU input
        Multiplexer dataPlex = new Multiplexer();

        //For data to register
        Multiplexer regWriteMult =  new Multiplexer();

        //ALU
        ALU alu = new ALU();

        //ALU controller
        ALUControl aluControl = new ALUControl();


        //Stuff needed
        int readData1 = 0;
        int readData2 = 0;
        int aluResult = 0;

        for(int i = 0 ; i < 5 ; i++){
            switch(i) {
                //IFetch Instruction fetch and Update pc
                case 0:
                    //Get the instruction at at pc current value
                    inst = instructionMemory.getInstruction(pc.getPC());
                    //Add a standard four to the pc
                    if(inst.getType() == InstructionTypes.EXIT) {
                        return -1;
                    }
                    pcAdd.add(pc.getPC(), 4);

                    //Set the result to input a in multiplexer
                    pcMultiplex.setInput(pcAdd.getResult(), null);
                    break;

                //DEC Register fetch and instruction decode
                case 1:
                    //Send the op code to the control unit
                    controlUnit.setValues(inst.getDecomposed()[0]);

                    //Read data from register address 1 and 2
                    readData1=registers.getRegister(inst.getDecomposed()[1]);
                    readData2=registers.getRegister(inst.getDecomposed()[2]);

                    //Set the inputs to write address multiplexer
                    regMult.setInput(inst.getDecomposed()[2],inst.getDecomposed()[3]);

                    //Performs the branch addition and sends the result to pc
                    // multiplexer second input.
                    System.out.println(inst.getDecomposedString());
                    branchAdd.add((inst.getDecomposed()[inst.getDecomposed().length-1]<<2),pcAdd.getResult());
                    pcMultiplex.setInput(null, branchAdd.getResult());

                    //Sends the funct code to the ALUControl unit
                    aluControl.setFunct(inst.getDecomposed()[inst.getDecomposed().length-1]);
                    break;

                //EXEC Execute R-type; calculate memory address
                case 2:

                    //Sets the inputs for the ALU and computes
                    dataPlex.setInput(readData2, inst.getDecomposed()[inst.getDecomposed().length-1]<<2);
                    dataPlex.setSignal(controlLines.isAluSrc());
                    aluControl.processInstruction(controlLines.getAluOP());
                    aluResult =alu.operate(readData1, (int)dataPlex.getOutput(), aluControl.getALUOP());


                    break;

                //MEM Read/Write the data from/to the data memory
                case 3:

                    int readData = 0;

                    //Set the pc multiplexer signal
                    pcMultiplex.setSignal(controlLines.isBranch() && alu.zeroFlag());

                    //Set the Mem to Reg write multiplexer signal
                    regWriteMult.setSignal(controlLines.isMemtoReg());

                    //Set the rite address multiplexer signal
                    regMult.setSignal(controlLines.isRegDst());

                    //Write to/from memory
                    if(controlLines.isMemWrite()) {
                        dataMemory.storeWord(readData2, aluResult);
                    } else if(controlLines.isMemRead()) {
                        readData=dataMemory.loadWord(aluResult);
                    }
                    //Set the input for the write mem to reg multiplex
                    regWriteMult.setInput(readData, aluResult);
                    break;

                // WB Write the result data into the register file
                case 4:
                    //Write if it is time!
                    if(controlLines.isRegWrite()) {
                        registers.setRegister((int)regMult.getOutput(),(int)regWriteMult.getOutput());
                    }
                    // Update the pc.
                    pc.setPc((int)pcMultiplex.getOutput());
                    break;
            }
        }

        return 0;
    }

    public int run() {
        while(true) {
            if (step() == -1) {
                return -1;
            }
        }
    }

    public int getPC() {
        return pc.getPC();
    }

    public void reset() {
        registers.reset();
        dataMemory.reset();
        pc.setPc(0);
    }
}
