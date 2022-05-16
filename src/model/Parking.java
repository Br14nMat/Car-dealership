package model;

/**
 * This class represents the Parking. The parking stores the old vehicles that could not be sold.
 */

public class Parking {
    
    /**
     * The vehicles in the parking.
     */
    private Vehicle [][] vehicles;

    /**
     * The rows of the parking.
     */
    private static final int ROWS = 10;

    /**
     * The columns of the parking. The first column contains the 2014 vehicles, the second column contains the 2013 vehicles and so on. The last column contains the <2011 vehicles.
     */
    private static final int COLUMNS = 5;

    /**
     * The constructor of the Parking class.
     */
    public Parking() {
        vehicles = new Vehicle[ROWS][COLUMNS];
    }

    /**
     * Method to show the parking map.<br>
     * The green squares are the available parking spots.<br>
     * The red squares are the taken parking spots.<br>
     * @return the parking map.
     */
    public String showParkingMap(){

        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_RESET = "\u001B[0m";
        int count = 0;

        String map = "";

        map += "Avaliable: " + ANSI_GREEN_BACKGROUND + "  " + ANSI_RESET;
        map += "\n";
        map += "Occupied:  " + ANSI_RED_BACKGROUND + "  " + ANSI_RESET;
        map += "\n \n";

        map += "14 13 12 11 <11 \n \n";

        for(int i = 0; i < vehicles.length; i++){

            for(int j = 0; j < vehicles[0].length; j++){

                if(vehicles[i][j] == null){
                    map += ANSI_GREEN_BACKGROUND + "  " + ANSI_RESET;
                    map += " ";
                }else{
                    map+= ANSI_RED_BACKGROUND + "  " + ANSI_RESET;
                    map += " ";
                    count++;
                }

            }

            map += "\n \n";

        }

        if(count == (ROWS * COLUMNS)){
            map += "The parking is full. It should be expanded.";
        }

        return map;

    }

    /**
     * Method to add a vehicle to the parking.
     * @param vehicle the vehicle to add.
     */
    public void add(Vehicle vehicle){

        int model = vehicle.getModel();

        if(model == 2014){

            int space = findSpaceInColumn(0);

            if(space != -1)
                vehicles[space][0] = vehicle;

        }

        if(model == 2013){

            int space = findSpaceInColumn(1);

            if(space != -1)
                vehicles[space][1] = vehicle;

        }

        if(model == 2012){

            int space = findSpaceInColumn(2);

            if(space != -1)
                vehicles[space][2] = vehicle;

        }

        if(model == 2011){

            int space = findSpaceInColumn(3);

            if(space != -1)
                vehicles[space][3] = vehicle;

        }

        if(model < 2011){

            int space = findSpaceInColumn(4);

            if(space != -1)
                vehicles[space][4] = vehicle;

        }

    }

    /**
     * Method to find a space in a column.
     * @param column the column to search.
     * @return the index of the space or -1 if there is no space.
     */
    public int findSpaceInColumn(int column){

        int index = -1;

        for(int i = 0; i < ROWS && index == -1; i++){

            if(vehicles[i][column] == null)
                index = i;

        }

        return index;
    } 
    
    /**
     * Method to generate a report by a range of years. The start and end years are included in the report [start, end].<br>
     * It return a message if there are no vehicles in the given range.<br>
     * @param start the start year.
     * @param end the end year.
     * @return the report.
     */
    public String oldCarsInRange(int start, int end){

        String report = "";

       do{
            for(int i = 0; i < vehicles.length; i++){
                if(vehicles[i][start - 1] != null)
                    report += vehicles[i][start - 1].toString() + "\n";

            }

            if(start != end)
                start--;

       }while(start != end);

       if(report.equals(""))
           report = "No cars in range.";

       return report;

    }

    /**
     * Method to calculate the percentage of the parking that is occupied.
     * @return the percentage of parking occupancy.
     */
    public double parkingOccupancyPercentage(){

        double count = 0;

        for(int i = 0; i < vehicles.length; i++){
            for(int j = 0; j < vehicles[0].length; j++){
                if(vehicles[i][j] != null)
                    count++;
            }
        }

        return (count / (ROWS * COLUMNS)) * 100;

    }

}
