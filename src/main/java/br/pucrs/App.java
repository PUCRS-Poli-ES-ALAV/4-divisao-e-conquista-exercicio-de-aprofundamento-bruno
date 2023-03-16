package br.pucrs;
import java.util.Arrays;
import java.util.Random;

public class App{
    public static void main (String[] args){

        long vet[] = new long[32]; // Teste com tamanho :  32, 2048 e 1.048.576

        int longervaloInicial = 0;
        int longervaloFinal = 100000;

        for(int i=0 ; i < vet.length; i++){
                vet [i] = getRandomNumberRange(longervaloInicial , longervaloFinal);
        }

        System.out.println(" \n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println(" \n Vetor Desordenado: " + Arrays.toString(vet));

        System.out.println(" \n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("\n Valor Máximo sem Divisão e Conquista: " + maxVal1(vet));

        System.out.println(" \n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("\n Valor Máximo com Divisão e Conquista: " + maxVal2(vet, 0, vet.length-1));

        System.out.println(" \n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        System.out.println("\n Vetor Ordenado: " + Arrays.toString(mergeSort(vet)));

    }

        private static int getRandomNumberRange(int min, int max)
        {
            Random r = new Random();
            return r.ints (min,(max+1)).limit(1).findFirst().getAsInt();
        }



        private static long[] mergeSort(long vector[]){ //EX1
            if(vector.length == 1){
                return vector;
            }
            else{
                int meio = vector.length/2;
                long vetor1[] = new long[meio];
                long vetor2[] = new long[vector.length - meio];
                for(int i = 0; i < meio; i++){
                    vetor1[i] = vector[i];
                }
                for(int i = meio; i < vector.length; i++){
                    vetor2[i - meio] = vector[i];
                }
                vetor1 = mergeSort(vetor1);
                vetor2 = mergeSort(vetor2);
                return merge(vetor1, vetor2);
            }
        }

        public static long[] merge(long vet1[], long vet2[]){ //EX1

            long vet3[] = new long[vet1.length + vet2.length];
            int i = 0;
            int j = 0;
            int k = 0;

            while(i < vet1.length && j < vet2.length){
                if(vet1[i] < vet2[j]){
                    vet3[k] = vet1[i];
                    i++;
                }
                else{
                    vet3[k] = vet2[j];
                    j++;
                }
                k++;
            }

            while(i < vet1.length){
                vet3[k] = vet1[i];
                i++;
                k++;
            }

            while(j < vet2.length){
                vet3[k] = vet2[j];
                j++;
                k++;
            }

            return vet3;
        }
            

        public static long maxVal1(long vet[]){ //EX2
            long max = 0;
            for(int i = 0; i<vet.length; i++){
                if(vet[i] > max){
                    max = vet[i];
                }
            }

            return max;
        }

        public static long maxVal2(long vet[], int init, int end) {  //EX3
            if (end - init <= 1)
                return max(vet[init], vet[end]);  
            else {
                int m = (init + end)/2;
                long v1 = maxVal2(vet,init,m);   
                long v2 = maxVal2(vet,m+1,end);  
                return max(v1,v2);
                }
        }

        public static long max(long a, long b) {  //EX3
            if (a > b) return a;  
            else return b;  
        }
    
}

