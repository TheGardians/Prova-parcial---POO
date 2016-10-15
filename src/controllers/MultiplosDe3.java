package controllers;

import exceptions.NaoMultiploDe3Exception;

public class MultiplosDe3 {
	
	static void testarMultiplosDe3(int [][]matriz) throws NaoMultiploDe3Exception{
		for(int i=0; i<matriz.length; i++){
			for(int j=0; j<matriz[i].length; j++){
				if(matriz[i][j] % 3 != 0){
					throw new NaoMultiploDe3Exception(i, j, "Erro: elemento não é múltiplo de 3.");
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int matriz[][] = new int[][] {{3, 6, 9, 12}, {15, 0, 18, 21}, {4, 27, 30, 33}, {36, 39, 42, 45}};
		try {
			testarMultiplosDe3(matriz);
			System.out.println("Todos são multiplos de 3.");
		} catch (NaoMultiploDe3Exception e) {
			System.out.println(e.getMessage()+" Elemento na posição "+e.getLinha()+" "+e.getColuna());
		}
	}
}
