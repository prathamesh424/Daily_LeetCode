import java.util.HashMap;
import java.util.PriorityQueue;

public class Map {

    class FoodRatings {
        private  HashMap<String , Integer > foodRating ;
        private  HashMap<String ,String > foodCuisines ;
        private  HashMap<String , PriorityQueue > AllInfo ;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodRating =  new HashMap<>() ; 
            foodCuisines = new HashMap<>();
            AllInfo = new HashMap<>();

            for (int i = 0; i < ratings.length; i++) {
                foodRating.put(foods[i], ratings[i]);
                foodCuisines.put(cuisines[i], foods[i]);
                AllInfo.computeIfAbsent(cuisines[i] , k -> new PriorityQueue<>()).add(new compare(foods[i], ratings[i]));
                
            }

            
        }
        
        public void changeRating(String food, int newRating) {
            foodRating.put(food, newRating);

            String cuisines = foodCuisines.get(food);

            AllInfo.get(cuisines).add(new compare(food, newRating)) ;
        }
        
        public String highestRated(String cuisine) {
            compare highestRated = (Map.compare) AllInfo.get(cuisine).peek() ;

            while (foodRating.get(highestRated.FoodName) != highestRated.FoodRating)) {
                AllInfo.get(cuisine).poll();
                highestRated = (Map.compare) AllInfo.get(cuisine).peek();
            }


            return highestRated.FoodName;

        } 
    }
    
    /**
     * Your FoodRatings object will be instantiated and called as such:
     * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
     * obj.changeRating(food,newRating);
     * String param_2 = obj.highestRated(cuisine);
     */

     class compare implements Comparable<compare>{
        public String FoodName ;
        public int FoodRating ;

        public compare (String FoodName , int FoodRating ){
            this.FoodName = FoodName ;
            this.FoodRating = FoodRating ;
        }

        @Override
        public int compareTo(compare next) {
            if(next.FoodRating == FoodRating ){
                return FoodName.compareTo(next.FoodName);
            }
        
            
            return -1 * Integer.compare(FoodRating, next.FoodRating) ;
        }

     }
}
