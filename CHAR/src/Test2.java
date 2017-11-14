/**
 * Created by ZHAOKANG on 2017/11/14.
 */
public class Test2 {

    public static boolean found = false;


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

    public static void generatePassword(char [] guessPassword,int index,String password)
    {
        if(found)
            return ;
        for (short i = '0'; i <'z' ; i++) {
            char c = (char)i;
            if(!Character.isLetterOrDigit(c))
                continue ;
            guessPassword[index]= c;
            if(index!=guessPassword.length-1)
            {
                generatePassword(guessPassword,index+1,password);
            }
            else
            {
                String guess = new String(guessPassword);
                if(guess.equals(password)){
                    System.out.println("找到了，密码是："+guess);
                    found = true ;
                    return ;
                }
            }
        }
    }
}
