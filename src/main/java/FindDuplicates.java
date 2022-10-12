import java.util.*;

public class FindDuplicates {

    public static void main (String [] args){

        Collection values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(4);
        values.add(1);
        values.add(4);


        System.out.println("Duplicates Values" + findDuplicatesValues(values));
    }


    private static <T> Set<T> findDuplicatesValues(Collection<T> collection){
        Set<T> duplicates = new LinkedHashSet<>();

        Set<T> uniques = new HashSet<>();

        for(T t: collection){
            if(!uniques.add(t)){
                duplicates.add(t);
            }

        }
        return duplicates;
    }
}
