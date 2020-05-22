import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import java.util.*;
import  java.time.*;
public class Main
{
    
    public static void fillMissingDates(Map<LocalDate,Integer> newDictionary,String prevDate,String nextDate,Integer firstValue,Integer lastValue){
        LocalDate start = LocalDate.parse(prevDate);
        LocalDate end = LocalDate.parse(nextDate);
        String[] str = prevDate.split("-");
        String[] str1 = nextDate.split("-");

        
        LocalDate dateBefore = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
	    LocalDate dateAfter = LocalDate.of(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]), Integer.parseInt(str1[2]));
 	    long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
 	    int value = 0;
 	    if(noOfDaysBetween!=0){
 	        value = (lastValue-firstValue)/(int)noOfDaysBetween;
 	    }
 	    
        List<LocalDate> totalDates = new ArrayList<>();
        
       while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
       }
       
       for(int i=0;i<totalDates.size();i++){
           if(i==0){
           newDictionary.put(totalDates.get(i),firstValue);
           continue;
           }
           if(i==totalDates.size()-1){
              newDictionary.put(totalDates.get(i),lastValue);
           }
           else{
              newDictionary.put(totalDates.get(i),firstValue+value);
              firstValue = firstValue+value;
           }
       }           
	   for (Map.Entry<LocalDate,Integer> entry : newDictionary.entrySet()) {
	         System.out.println(entry.getKey()+" "+entry.getValue());
	   }
        
    }
	public static void main(String[] args) {
	    Map<String,Integer> oldDictionary = new LinkedHashMap<String,Integer>();
	    oldDictionary.put("2019-01-01",100);
	    oldDictionary.put("2019-01-04",115);
	    Map<LocalDate,Integer> newDictionary = new LinkedHashMap<LocalDate,Integer>();
	    String prev=null;
	    int count=0;
	    int firstValue = 0;
	           
	   for (Map.Entry<String,Integer> entry :oldDictionary.entrySet()) {
	     
		if(count==0){
            prev = entry.getKey();
            firstValue = entry.getValue();
            count++;
	    }
	    else{
	        String  next = entry.getKey();
	        int lastValue = entry.getValue();
	        fillMissingDates(newDictionary,prev,next,firstValue,lastValue);
	        prev = next;
	        firstValue = lastValue;
	    }
	            
	}      
    } 
	}
