/**
 * Created by ZHAOKANG on 2017/11/14.
 */
public class Test1 {


    //随机构造字符串
    private static String randomString(int length)
    {
        String pool = "";
        for (short i = '0'; i < '9'; i++) {
            pool += (char)i;
        }
        for (short i = 'a'; i < 'z'; i++) {
            pool += (char)i;
        }
        for (short i = 'A'; i < 'Z'; i++) {
            pool += (char)i;
        }
        char cs [] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int)(Math.random()*pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }

    public static void main(String [] args)
    {
        String passward = randomString(3);
        System.out.println("密码是："+passward);

        char [] guessPassword = new char[3] ;
        outloop:
        for (short i = '0'; i < 'z'; i++) {
            for (int j = '0'; j < 'z'; j++) {
                for (int k = '0'; k <'z' ; k++) {
                    if(!isLetterOrDigit(i,j,k))
                        continue;
                    guessPassword[0] = (char)i;
                    guessPassword[1] = (char)j;
                    guessPassword[2] = (char)k;
                    String guess = new String(guessPassword);

                    if(guess.equals(passward))
                    {
                        System.out.println("找到了，密码是"+guess);
                        break outloop;
                    }
                }
            }

        }
    }

    private static boolean isLetterOrDigit(short i, int j, int k) {
        return Character.isLetterOrDigit(i) &&
                Character.isLetterOrDigit(j) &&
                Character.isLetterOrDigit(k);
    }
}
