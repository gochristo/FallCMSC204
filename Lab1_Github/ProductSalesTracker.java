public class ProductSalesTracker{
    private double[] sales;
    private int salesSize;

    public ProductSalesTracker(int capacity) {
        sales = new double[capacity];
        salesSize = 0;
    }
    public boolean addSale(double sale) {
        if(salesSize < sales.length){
            sales[salesSize] = sale;
            salesSize++;
            return true;
        }

        return false;
    }

    public double totalSales(){
        double total = 0.0;
        for(int i = 0; i < sales.length; i++){
            total += sales[i];
        }
        return total;
    }

    public double lowestSale(){
        if(salesSize == 0){
            return 0.0;
        }

        double lowest = sales[0];

        for(int i = 1; i < salesSize; i++){
            if(sales[i] < lowest){
                lowest = sales[i];
            }
        }
        return lowest;
    }

    public double finalSalesTotal(){
        if(salesSize < 2){
            return 0.0;
        }

        double total = 0.0;
        double lowest = lowestSale();

        for(int i = 0; i < salesSize; i++){
            total += sales[i];
        }
        total -= lowest;

        return total;
    }

    public String toString(){
        if(salesSize == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < salesSize; i++){
            sb.append(sales[i]);
            if(i != salesSize-1){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}