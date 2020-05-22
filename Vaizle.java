/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit ;
import  java.time.*;
public class Vaizle
{
    
    public static void fillMissingDates(Map<LocalDate,Integer> map,String prevDate,String nextDate){
        LocalDate start = LocalDate.parse(prevDate);
        LocalDate end = LocalDate.parse(nextDate);
        List<LocalDate> totalDates = new ArrayList<>();
       while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
       }
       for(int i=0;i<totalDates.size();i++){
           map.put(totalDates.get(i),null);
       }           
	   for (Map.Entry<LocalDate,Integer> entry : map.entrySet()) {
	         System.out.println(entry.getKey()+" "+entry.getValue());
	            }
        
    }
	public static void main(String[] args) {
	    Map<String,Integer> map = new LinkedHashMap<String,Integer>();
	    map.put("2019-01-01",100);
	    map.put("2019-01-04",115);
	    Map<LocalDate,Integer> map1 = new LinkedHashMap<LocalDate,Integer>();
	    String prev=null;
	    int count=0;
	  
	           
	   for (Map.Entry<String,Integer> entry : map.entrySet()) {
	                   if(count==0){
                  prev = entry.getKey();
                  count++;
	       }
	       else{
	           String  next = entry.getKey();
	           fillMissingDates(map1,prev,entry.getKey());
	           prev = next;
	       }
	            }
	           
	     
	
         
    } 
	}


