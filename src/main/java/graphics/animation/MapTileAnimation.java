package graphics.animation;

import graphics.map.EMap;
import graphics.map.MapFactory;
import org.newdawn.slick.tiled.TiledMap;

public class MapTileAnimation {

    private TiledMap map = MapFactory.getMapFactory().getMaps(EMap.MAP1);
    private int countLift1 = 0;
    private int countLift2 = 0;
    private int countLift3 = 0;
    private int countLift5 = 0;
    private int countLift4 = 0;
    private int lift1Y = 45;
    private int lift2Y = 34;
    private int lift3Y = 12;
    private int lift4Y = 27;
    private int lift5Y = 45;

    public MapTileAnimation() {
    }

    public void update(){
        lift1();
        lift2();
        lift3();
        lift4();
        lift5();
    }

    public void lift1(){
        countLift1++;
        if(countLift1 == 4){
            countLift1 = 0;
            if((map.getTileId(9, lift1Y, 2) == 218) && (lift1Y > 34)) {
                map.setTileId(9, lift1Y, 2, 206);
                if (lift1Y < 45) {
                    map.setTileId(9, lift1Y+1, 2, 203);}
                if(lift1Y == 35) {
                    map.setTileId(9, lift1Y, 2, 203);
                }
                lift1Y--;
                if(lift1Y == 34){
                    lift1Y++;
                }
            }
            else if((map.getTileId(9, lift1Y, 2) == 203) && (lift1Y < 46)){
                map.setTileId(9, lift1Y, 2, 217);
                if(lift1Y >35){
                    map.setTileId(9, lift1Y-1, 2, 218);
                }
                if(lift1Y == 45){
                    map.setTileId(9, lift1Y, 2, 218);
                }
                lift1Y++;
                if(lift1Y == 46){
                    lift1Y--;
                }
            }
        }
    }

    public void lift2(){
        countLift2++;
        if(countLift2 == 4){
            countLift2 = 0;
            if((map.getTileId(12, lift2Y, 2) == 218) && (lift2Y > 4)) {
                map.setTileId(12, lift2Y, 2, 206);
                if (lift2Y < 34) {
                    map.setTileId(12, lift2Y+1, 2, 203);}
                if(lift2Y == 5) {
                    map.setTileId(12, lift2Y, 2, 203);
                }
                lift2Y--;
                if(lift2Y == 4){
                    lift2Y++;
                }
            }
            else if((map.getTileId(12, lift2Y, 2) == 203) && (lift2Y < 35)){
                map.setTileId(12, lift2Y, 2, 217);
                if(lift2Y > 5){
                    map.setTileId(12, lift2Y-1, 2, 218);
                }
                if(lift2Y == 34){
                    map.setTileId(12, lift2Y, 2, 218);
                }
                lift2Y++;
                if(lift2Y == 35){
                    lift2Y--;
                }
            }
        }
    }

    public void lift3(){
        countLift3++;
        if(countLift3 == 4){
            countLift3 = 0;
            if((map.getTileId(22, lift3Y, 2) == 218) && (lift3Y > 4)) {
                map.setTileId(22, lift3Y, 2, 206);
                if (lift3Y < 12) {
                    map.setTileId(22, lift3Y+1, 2, 203);}
                if(lift3Y == 5) {
                    map.setTileId(22, lift3Y, 2, 203);
                }
                lift3Y--;
                if(lift3Y == 4){
                    lift3Y++;
                }
            }
            else if((map.getTileId(22, lift3Y, 2) == 203) && (lift3Y < 13)){
                map.setTileId(22, lift3Y, 2, 217);
                if(lift3Y > 5){
                    map.setTileId(22, lift3Y-1, 2, 218);
                }
                if(lift3Y == 12){
                    map.setTileId(22, lift3Y, 2, 218);
                }
                lift3Y++;
                if(lift3Y == 13){
                    lift3Y--;
                }
            }
        }
    }

    public void lift4(){
        countLift4++;
        if(countLift4 == 4){
            countLift4 = 0;
            if((map.getTileId(34, lift4Y, 2) == 218) && (lift4Y > 12)) {
                map.setTileId(34, lift4Y, 2, 206);
                if (lift4Y < 27) {
                    map.setTileId(34, lift4Y+1, 2, 203);}
                if(lift4Y == 13) {
                    map.setTileId(34, lift4Y, 2, 203);
                }
                lift4Y--;
                if(lift4Y == 12){
                    lift4Y++;
                }
            }
            else if((map.getTileId(34, lift4Y, 2) == 203) && (lift4Y < 28)){
                map.setTileId(34, lift4Y, 2, 217);
                if(lift4Y > 13){
                    map.setTileId(34, lift4Y-1, 2, 218);
                }
                if(lift4Y == 27){
                    map.setTileId(34, lift4Y, 2, 218);
                }
                lift4Y++;
                if(lift4Y == 28){
                    lift4Y--;
                }
            }
        }
    }

    public void lift5(){
        countLift5++;
        if(countLift5 == 4){
            countLift5 = 0;
            if((map.getTileId(41, lift5Y, 2) == 218) && (lift5Y > 27)) {
                map.setTileId(41, lift5Y, 2, 206);
                if (lift5Y < 45) {
                    map.setTileId(41, lift5Y+1, 2, 203);}
                if(lift5Y == 28) {
                    map.setTileId(41, lift5Y, 2, 203);
                }
                lift5Y--;
                if(lift5Y == 27){
                    lift5Y++;
                }
            }
            else if((map.getTileId(41, lift5Y, 2) == 203) && (lift5Y < 46)){
                map.setTileId(41, lift5Y, 2, 217);
                if(lift5Y > 28){
                    map.setTileId(41, lift5Y-1, 2, 218);
                }
                if(lift5Y == 45){
                    map.setTileId(41, lift5Y, 2, 218);
                }
                lift5Y++;
                if(lift5Y == 46){
                    lift5Y--;
                }
            }
        }
    }

    private void liftSwag() {
        countLift1++;
        if(countLift1 == 40){
            countLift1 = 0;
            if((map.getTileId(9, lift1Y, 2) == 218) && (lift1Y > 35))
            {
                map.setTileId(9, lift1Y, 2, 206);
                lift1Y--;
            }
            else if(lift1Y<46)
            {
                System.out.println(lift1Y);
                map.setTileId(9, lift1Y, 2, 218);

                if(lift1Y<45){
                    lift1Y++;
                }
            }
            else {
                liftSwag();
            }
        }
    }
}
