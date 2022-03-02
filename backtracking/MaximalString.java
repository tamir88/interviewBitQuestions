package backtracking;

public class MaximalString {
    String str = "";

    public String solve(String A, int B) {
        str=A;
        findMax(str,B);
        return str;
    }

    public void findMax(String temp, int B){
        if(Integer.parseInt(temp) > Integer.parseInt(str)){
            str=temp;
        }
        if(B == 0) return;
        for(int i=0;i<temp.length()-1;i++){
            for(int j=i+1;j<temp.length();j++){
                if(temp.charAt(i) < temp.charAt(j))
                    temp=swap(temp,i,j);
                findMax(temp,B-1);
                temp=swap(temp,i,j);
            }
        }
    }

    public String swap(String str, int i, int j){
        char i_th = str.charAt(i);
        char j_th = str.charAt(j);

        String left = str.substring(0,i);
        String middle = str.substring(i+1,j);
        String right = str.substring(j+1);

        return left + j_th + middle + i_th + right;
    }

    public static void main(String[] args) {
        MaximalString a = new MaximalString();
        System.out.println(a.solve("3677191", 3));
    }

}
