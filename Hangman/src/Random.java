public class Random {


    //generates random numbers in a given range
    public int RandomNumber(int min, int max){
        Random random = new Random();
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
