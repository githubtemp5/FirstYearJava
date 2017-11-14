import java.util.*;

/**
 * Class to represent a harbour.
 * 
 * @author Claire Ancient
 * @version 2017.02.15
 */
public class Harbour {
    private ArrayList<Boat> harbour;

    /**
     * Initialisation required for the harbour list
     */
    public Harbour() {
        harbour = new ArrayList<Boat>();
        
        dockBoat(new Boat("Cyan", 10, "Southampton", 23));
        dockBoat(new Boat("Octopus", 42, "Liverpool", 56));
        dockBoat(new Boat("Lionheart", 50, "Southampton", 1));
        dockBoat(new Boat("Seven Seas", 10, "Southampton", 16));
        dockBoat(new Boat("Hokulani", 200, "Plymouth", 3));
        dockBoat(new Boat("Baglietto", 10, "Liverpool", 45));
        dockBoat(new Boat("The Maraya", 10, "Southampton", 37));
        dockBoat(new Boat("Serenity", 42, "Plymouth", 81));
        dockBoat(new Boat("Dreamweaver", 42, "Plymouth", 19));
        dockBoat(new Boat("Pegasus", 50, "Liverpool", 67));
        
    }

    /**
     * Store a new boat in the harbour list
     * @param   newBoat     the boat to be stored
     */
    public void dockBoat(Boat newBoat) {
        harbour.add(newBoat);
    }
    
    /**
     * The number of boats currently docked at the harbour
     * @return      the number of boats in the harbour
     */
    public int countBoats() {
       return harbour.size();
    }
    
    /**
     * Undock a boat from the harbour
     * @param   i   index of the boat to undock
     */
    public void undockBoat(int i) {
        if (i < harbour.size() && i >= 0) {
            harbour.remove(i);
        }

        
    }
    
    /**
     * Print the details of boats which have a particular engine horsepower
     * @param   reqEngine     the engine horsepower to print the associated boats for
     */
    public void printBoatsWithParticularEngine(int reqEngine) {
        for (Boat currentBoat: harbour) {
            if(currentBoat.getEngineSize() == reqEngine) {
                currentBoat.printBoatDetails();
                System.out.println("");
            }
        }
    }
    
    /**
     * Find a particular boat based on the name, and print the details
     * @param   searchName     the name of the boat where the details are required
     */
    public void findBoat(String searchName)
    {
        for (Boat currentBoat: harbour) {
            if(currentBoat.getBoatName().equals(searchName)) {
                currentBoat.printBoatDetails();
            }
        }
    }
}
