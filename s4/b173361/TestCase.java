package s4.b173361; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
//package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/


public class TestCase {
    public static void main(String[] args) {
	try {
	    FrequencerInterface  myObject;
	    int freq;
        
	    System.out.println("checking s4.b173361.Frequencer");
	    myObject = new s4.b173361.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        /* correction start */
        // No target
        FrequencerInterface  myObjectNotarget;
        int freqNotarget;
        
        myObjectNotarget = new s4.b173361.Frequencer();
        myObjectNotarget.setSpace("Hi Ho Hi Ho".getBytes());
        freqNotarget = myObjectNotarget.frequency();
        System.out.print("No target           ");
        if(-1 == freqNotarget) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        // target length is 0
        FrequencerInterface  myObjectTargetLength0;
        int freqTargetLength0;
        
        myObjectTargetLength0 = new s4.b173361.Frequencer();
        myObjectTargetLength0.setSpace("Hi Ho Hi Ho".getBytes());
        myObjectTargetLength0.setTarget("".getBytes());
        freqTargetLength0 = myObjectTargetLength0.frequency();
        System.out.print("target length is 0    ");
        if(-1 == freqTargetLength0) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        // No space
        FrequencerInterface  myObjectNospace;
        int freqNospace;
        
        myObjectNospace = new s4.b173361.Frequencer();
        myObjectNospace.setTarget("H".getBytes());
        freqNospace = myObjectNospace.frequency();
        System.out.print("No space            ");
        if(0 == freqNospace) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        // space length is 0
        FrequencerInterface  myObjectSpaceLength0;
        int freqSpaceLength0;
        
        myObjectSpaceLength0 = new s4.b173361.Frequencer();
        myObjectSpaceLength0.setSpace("".getBytes());
        myObjectSpaceLength0.setTarget("H".getBytes());
        freqSpaceLength0 = myObjectSpaceLength0.frequency();
        System.out.print("Space length is 0     ");
        if(0 == freqSpaceLength0) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        
        // Is it OK?
        FrequencerInterface  myObject1;
        int freq1;
        
        myObject1 = new s4.b173361.Frequencer();
        myObject1.setSpace("HHHH".getBytes());
        myObject1.setTarget("HH".getBytes());
        freq1 = myObject1.frequency();
        System.out.print("Is it OK?     ");
        if(2 == freq1) { System.out.println("OK"); } else {System.out.println("WRONG"); }



        /* correction end */

	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.b173361.InformationEstimator");
	    myObject = new s4.b173361.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);
	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    System.out.println(">01 "+value);
	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0123 "+value);
	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
	    System.out.println(">00 "+value);
        
        /* correction start */
        myObject.setTarget("8".getBytes());
        value = myObject.estimation();
        System.out.println(">8 "+value);
        /* correction end */
        
        
        /* correction start */
        // No target
        InformationEstimatorInterface myObjectNotarget;
        double valueNotarget;
        myObjectNotarget = new s4.b173361.InformationEstimator();
        myObjectNotarget.setSpace("3210321001230123".getBytes());

        valueNotarget = myObjectNotarget.estimation();
        System.out.print("No target           ");
        if(0 == valueNotarget) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        
        // target length is 0
        InformationEstimatorInterface myObjectTargetLength0;
        double valueTargetLength0;
        myObjectTargetLength0 = new s4.b173361.InformationEstimator();
        myObjectTargetLength0.setSpace("3210321001230123".getBytes());
        
        myObjectTargetLength0.setTarget("".getBytes());
        valueTargetLength0 = myObjectTargetLength0.estimation();
        System.out.print("target length is 0    ");
        if(0 == valueTargetLength0) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        
        // true value is infinite
        InformationEstimatorInterface myObjectInfinite;
        double valueInfinite;
        myObjectInfinite = new s4.b173361.InformationEstimator();
        myObjectInfinite.setSpace("3210321001230123".getBytes());
       
        myObjectInfinite.setTarget("8".getBytes());
        valueInfinite = myObjectInfinite.estimation();
        System.out.print("true value is infinite    ");
        if(Double.MAX_VALUE == valueInfinite) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        
        // No space
        InformationEstimatorInterface myObjectNospace;
        double valueNospace;
        myObjectNospace = new s4.b173361.InformationEstimator();
       
        myObjectNospace.setTarget("0".getBytes());
        valueNospace = myObjectNospace.estimation();
        System.out.print("No space    ");
        if(Double.MAX_VALUE == valueNospace) { System.out.println("OK"); } else {System.out.println("WRONG"); }

        
        
        /* correction end */
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}	    
	    
