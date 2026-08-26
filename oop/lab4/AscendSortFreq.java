/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author intel
 */
public class AscendSortFreq {
    private int n;
    private int DataField [] = new int[n];
    AscendSortFreq(int DataField[]){
        this.DataField = DataField;
    }
    public int []AscendSort(int DataField[]){
        int temp;
        for(int i = 0;i<DataField.length-1;i++){
            for(int j=0;j<DataField.length-i-1;j++){
                if(DataField[j] > DataField[j+1] ){
                    temp = DataField[j];
                    DataField[j] = DataField[j+1];
                    DataField[j+1] = temp;
                }
            }
        }
        return DataField;
    }
    public int []SortCommuFreq(int DataField[]){
        
        int count = 1;
        for(int i =1;i<DataField.length;i++){
            if(DataField[i] != DataField[i -1]){
                count++;
            }
        }
        int arr[] = new int[count];
        int Freq = 0; 
        int Index = 0;       
        for(int i =0;i<DataField.length;i++){
            Freq++;
            if(i == DataField.length - 1 || DataField[i] != DataField[i+1]){
                arr[Index] = Freq;
                Index++;
            }
        }
        return arr;
    } 
    public static void main(String []args){
        int[] A = {9, 5, 9, 5, 8};

        AscendSortFreq obj = new AscendSortFreq(A);

        int[] B = obj.AscendSort(A);

        int[] C = obj.SortCommuFreq(B);

        System.out.print(": ");

        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
           
        }

        System.out.println();

        System.out.print(": ");

        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i] + " ");
        }
    }
}
