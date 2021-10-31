package ru.geekbrains;

public class Les2 {

    public static int myArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {  //

        int summ = 0;


        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {

                try {
                    summ += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в символе в следующей ячейке: " + "строка: " + (i + 1) + ", " + "столбец: " + (j + 1));
                   
                }


            }

        }

        return summ;
    }


    public static void main(String[] args) throws MyArraySizeException {

        String[][] Arr1_corr = {  //корректный
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] Arr2_uncorr = {  //не корректный
                {"1", "2", "3"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] Arr3_uncorr = {
                {"1", "2", "3", "4"},
                {"5", "6", "9", "8"},
                {"9", "10", "6", "12"},
                {"D", "14", "15", "16"}
        };

        try {

            System.out.println(myArr(Arr1_corr));
            System.out.println(myArr(Arr2_uncorr));
            
        } catch (MyArraySizeException e) {
            System.out.println("Размеры массива не корректны");
        } //catch (MyArrayDataException e) {
            //System.out.println("данные в ячейке не корректны");
            //  }
        System.out.println(myArr(Arr3_uncorr)); 
    }

}
