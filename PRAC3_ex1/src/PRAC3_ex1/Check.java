package PRAC3_ex1;

public class Check {
	
	public static void main(String[] args) {
		try {
			Tank tank1 = new Tank();
			Tank tank2 = new Tank("Tank 2", "bla, bla, bla", 70.6, 80, 100, "./images/bg.png", 15, 7);
			
			/*Si cambias el null de "new Item" por "tank1", 
			 * entonces tank1.addItem(item1) debe lanzar una Excepcion 
			 * diciendo que el item1 ya est� en el tanque.
			 * Para que el programa funcione, o pones null y dejas tank1.addItem(item1), 
			 * o pones tank1 y comentas/borras tank1.addItem(item1).
			 * En cualquier caso el resultado debe ser el mismo: item1 a�adido en el tank1.
			 * 
			 */
			Item item1 = new Item(0, 0, "./images/fish.png", 10, 50, 24, null);
			Item item2 = new Item(0, 0, "./images/fish2.png", 10, 50, 0, null);
			
			System.out.println("_________________");
			System.out.println("|    TEST 0     |");
			System.out.println("|_______________|");
			
			tank1.addItem(item1);
			
			System.out.println(tank1); //Debe salir la informacion de tank1 ("Default") con el item1 a�adido
			
			System.out.println("_________________");
			System.out.println("|    TEST 1     |");
			System.out.println("|_______________|");
			
			item1.setTank(null);
			
			System.out.println("\n"+item1); //Debe salir la informacion de item1 con "No tank" como nombre del tanque
			
			System.out.println("_________________");
			System.out.println("|    TEST 2     |");
			System.out.println("|_______________|");
			
			item1.setTank(tank1);
			
			System.out.println(tank1); //Debe salir la informacion de tank1 ("Default") con el item1 a�adido
			
			System.out.println("_________________");
			System.out.println("|    TEST 3     |");
			System.out.println("|_______________|");
			
			tank1.removeItem(item1);
			
			System.out.println(tank1); //Debe salir la informacion de tank1 ("Default") SIN el item1 a�adido
			
			System.out.println("\n"+item1); //Debe salir la informacion de item1 con "No tank" como nombre del tanque
			
			System.out.println("_________________");
			System.out.println("|    TEST 4     |");
			System.out.println("|_______________|");
			
			tank1.addItem(item2);
			System.out.println(tank1); //Debe salir la informacion de tank1 ("Default") CON SOLO el item2 a�adido
			
			System.out.println("_________________");
			System.out.println("|    TEST 5     |");
			System.out.println("|_______________|");
			
			tank1.removeDeadItems();
			
			System.out.println(tank1); //Debe salir la informacion de tank1 ("Default") VACIO
			System.out.println("\n"+item2); //Informacion de item2 con "No tank".
						
			System.out.println("_________________");
			System.out.println("|    TEST 6     |");
			System.out.println("|_______________|");
			
			item1.setTank(tank2);
			item2.setTank(tank2);
			
			System.out.println(tank2); //Debe salir la informacion de tank2 con item1 e item2 a�adidos
			
			
			System.out.println("_________________");
			System.out.println("|    TEST 7     |");
			System.out.println("|_______________|");
			
			tank2.empty();			
			System.out.println(tank2); //Debe salir la informacion de tank2 VACIO			
			System.out.println("\n"+item1+"\n"+item2); //Ambos items con "No tank"
			
		} catch (ItemException e) {
			e.printStackTrace();
		} catch (TankException e) {
			e.printStackTrace();
		}		
	}

}
