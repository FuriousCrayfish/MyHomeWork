public class HomeWork2 {

    /*Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
     0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */


   public static void arrayChange(){
// length переменная указывающая длинну созданного массива

       int[] array = new int []{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
       for (int i =0;i < array.length;i++){
           if(array[i] == 1){
               array[i] = 0;

           }else{
               array[i]=1;
           }
           System.out.print(array[i]);
       }
       System.out.println();
       array[7] = 0;
       System.out.println(array[7]);
   }





}
