package notSelenium;

import java.util.*;



public class Solutions {

    public static void main(String[] args) {
        String S = "id,name,age,score\n1,Jack,NULL,12\n17,Betty,28,11";
        String Sa = "id,name,age,score\n1,Jack,NULL,12\nNULL,Betty,28,11";
        String Sa1 = "id,name,age,score\n1,Jack,NULL,12\nNULL,Betty,28,11\n18,Betty,28,11";
        System.out.println(solution(S));
        System.out.println(solution(Sa));
        System.out.println(solution(Sa1));
    }

    public static String solution(String S) {
            // write your code in Java SE 8

            ArrayList<String> data = new ArrayList<String>();
            String[] rows = S.split("\n");
            int size = rows.length;
            int dataSize = data.size();
            String output = "";

            for (int i = 0; i < size; i++){
                data.add(rows[i]);
            }

            for (int i =0; i < data.size(); i++){
                if (data.get(i).contains(",NULL,") || data.get(i).contains("NULL\n") || data.get(i).contains( ",NULL")
                || data.get(i).contains("\n,NULL,")){
                    data.remove(i);
                }
            }

            for (int i =0; i < data.size(); i++){
                output += data.get(i) + "\n";
            }

            //String refineOuput = output.substring(0, output.length() -1);
            return output;

        }



}
