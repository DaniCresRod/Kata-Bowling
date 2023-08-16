package org.example;

public class Game {

    private int totalScore=0;
    private int[] framePoints=new int[10];
    public int frameNumber=0;  //Max 10
    private int frameNumberThrow=1;
    private int bonus=0;
    private int[] strikes=new int[2];

    void Roll(int pins){
        if(frameNumber<framePoints.length){

            if(bonus>0){
                framePoints[frameNumber-1]+=pins;
                bonus--;
            }

            if(frameNumberThrow==1){
                strikes[0]=pins;
                framePoints[frameNumber]+=pins;
                if(strikes[0]==10){
                    bonus=2;
                    frameNumber++;
                }
                else{
                    frameNumberThrow++;
                }


            }
            else if(frameNumberThrow==2){
                strikes[1]=pins;
                framePoints[frameNumber]+=pins;
                if(strikes[0]+strikes[1]==10){
                    bonus=1;
                }
                frameNumberThrow=1;
                frameNumber++;
                totalScore+=pins;
            }



//            if(frameNumberThrow==1){
//                if(pins==10){
//
//
//                }
//                else{
//                    framePoints[frameNumber]=pins;
//                    if((frameNumber>0) && (framePoints[frameNumber-1]>=10)){
//                        framePoints[frameNumber-1]+=pins;
//                    }
//                    frameNumberThrow++;
//
//                }
//            }
//            else{
//                framePoints[frameNumber]+=pins;
//                frameNumberThrow=1;
//                frameNumber++;
//            }
        }
    }

    int score(){
        totalScore=0;
        for(int i=0; i<framePoints.length;i++){
            totalScore+=framePoints[i];
        }
        return this.totalScore;
    }
}
