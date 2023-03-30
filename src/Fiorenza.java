import java.util.Scanner;

public class Fiorenza
{
	static Scanner in = new Scanner(System.in);
	static int[] array1 = new int[20];
	static int[] Attaccante = new int[3];
	static int[] Difensore = new int[3];
	static int[] array10 = new int[10];
	public static void main(String[] args)
	{
		while(true)
		{
			stampaMenu();
			int scelta = Integer.parseInt(in.nextLine());
			switch(scelta)
			{ 
				case 1:
					ugualiconsecutivi();
				break;
				case 2:
					lanciorisiko();
				break;
				case 3:
					zigzag();
				break;
				case 4:
					minimodiarray();
				break;
				default:
					System.out.println("Scelta errata, riprova!");

			}
		}
	}
	static void stampaMenu()
	{
		System.out.println("1 - Es n. 7 - Titolo es. Uguali Consecutivi");
		System.out.println("2 - Es n. 6 - Titolo es. lancio risiko");
		System.out.println("3 - Es n. 5 - Titolo es. Stampa zigzag");
		System.out.println("4 - Es n. 1 - Titolo es. Minnimo di array");
	}
	static void minimodiarray()
	{
		numDaMenoCinqueeCinque(array10);
		System.out.println("Questo è l'array: ");
		stampaArray(array10);
		
		int minore = array10[0];
		int posizione = 0;
		for(int i = 1;i < array10.length;i++)
		{
			if(minore > array10[i])
			{
				minore = array10[i];
				posizione = i;
			}
		}
		
		System.out.println("Il numero minore dell'array è: "+minore+"\nLa posizione del numero è: "+posizione);
	}
	static void zigzag()
	{
		numDaZeroADieci(array10);
		System.out.println("Ordine normale dell'array:");
		stampaArray(array10);
		
		System.out.println("Ordine zigzag dell'array:");
		for(int i = 0;i < array10.length/2;i++)
		{
			System.out.print("|"+array10[i]+"|"+array10[(array10.length-1)-i]);
		}
		System.out.print("|\n");
	}
	static void lanciorisiko()
	{
		GeneraDadi(Attaccante);
		OrdinaArray(Attaccante);
		System.out.println("I dadi dell'attaccante sono:");
		stampaArray(Attaccante);
		
		GeneraDadi(Difensore);
		OrdinaArray(Difensore);
		System.out.println("I dadi del difensore sono:");
		stampaArray(Difensore);
		
		int carridist = 0;
		for(int i = 0;i < Attaccante.length;i++)
		{
			if(Attaccante[i] > Difensore[i])
			{
				System.out.println((i+1)+ "° round: carro armato distrutto");
				carridist += 1;
			}
			if(Attaccante[i] <= Difensore[i])
			{
				System.out.println((i+1)+ "° round: carro armato salvo");
			}
		}
		System.out.println("\n"+"Il numero di carri armati distrutti è: "+carridist+"\n");
	}
	static void ugualiconsecutivi()
	{
		numdaMenoTreeTre(array1);
		System.out.println("Il contenuto dell'array è:");
		stampaArray(array1);
		
		boolean uguali = true;
		for(int i = 0;i < (array1.length-1);i++)
		{
			if(array1[i] == array1[i+1])
			{
				if(uguali == true)
				{
					System.out.println("Sono presenti numeri uguali consecutivi\n");
					uguali = false;
				}
				System.out.println("|"+array1[i]+"|"+array1[i+1]+"|"+"posizione:"+"|"+i+"|"+(i+1)+"|");
			}
		}
		if (uguali==true)
			System.out.println("Non sono presenti numeri uguali consecutivi");
	}
	static void OrdinaArray(int[] array)
	{
		for(int i = (array.length-1);i > 0;i--)
		{
			if(array[i-1] < array[i])
			{
				swap(i-1,i,array);
			}
		}
	}
	static void numDaMenoCinqueeCinque(int[] array)
	{
		for(int i = 0; i < array.length;i++)
		{
			array[i] = (int)(Math.random()* 11)-5;
		}
	}
	static void numDaZeroADieci(int[] array)
	{
		for(int i = 0; i < array.length;i++)
		{
			array[i] = (int)(Math.random()* 11);
		}
	}
	static void GeneraDadi(int[] array)
	{
		for(int i = 0; i < array.length;i++)
		{
			array[i] = (int)((Math.random()* 6)+1);
		}
	}
	static void numdaMenoTreeTre(int[] array)
	{
		for(int i = 0; i < array.length;i++)
		{
			array[i] = (int)(Math.random()* 7)-3;
		}
	}
	static void stampaArray(int[] array)
	{
		for(int i = 0; i < array.length;i++)
		{
			System.out.print("|"+array[i]);
		}
		System.out.println("|\n");
	}
	static void swap(int n, int n2,int[] arr)
	{
		int copia = arr[n];
		arr[n] = arr[n2];
		arr[n2] = copia;
		
	}
}
